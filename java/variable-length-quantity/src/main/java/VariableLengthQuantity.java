import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class VariableLengthQuantity {

    private static final String LAST_BYTE_IN_SERIES = "0";
    private static final String PRECEDING_BYTE_IN_SERIES = "1";

    private static final int VLQ_BYTE_LENGTH = 7;

    private boolean LAST_BYTE = true;

    public static final long SET_BIT_7 = 128;

    List<String> encode(List<Long> numbers) {
        return numbers.stream()
                .map(this::encodeSingleNumber)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> encodeSingleNumber(Long number) {
        List<String> vlqBytes = new ArrayList<>();

        vlqBytes.add(convertLeftmostBitsToHex(number & 0x7Fl));

        number >>= VLQ_BYTE_LENGTH;
        while (number > 0) {
            vlqBytes.add(convertLeftmostBitsToHex(SET_BIT_7 | (number & 0x7Fl)));
            number >>= VLQ_BYTE_LENGTH;
        }

        Collections.reverse(vlqBytes);
        return vlqBytes;
    }

    private String convertLeftmostBitsToHex(long l) {
        return "0x" + Long.toHexString(l);
    }


    private String getEncodingBit() {
        if (LAST_BYTE) {
            LAST_BYTE = false;
            return LAST_BYTE_IN_SERIES;
        }
        return PRECEDING_BYTE_IN_SERIES;
    }

    private String getNextBitsToEncode(String remainingBits) {
        String bits0to6;
        if (remainingBits.length() < VLQ_BYTE_LENGTH) {
            bits0to6 = ensureExactly7BitLength(remainingBits);
        } else {
            bits0to6 = remainingBits.substring(remainingBits.length() - VLQ_BYTE_LENGTH);
        }
        return bits0to6;
    }

    private String removeBitsJustEncoded(String remainingBits) {
        int endIndex = Math.max(0, remainingBits.length() - VLQ_BYTE_LENGTH);
        remainingBits = remainingBits.substring(0, endIndex);
        return remainingBits;
    }

    List<String> decode(List<Long> bytes) {
        List<String> result = new ArrayList<>();

        ArrayList<Long> thisSeries = new ArrayList<>();
        for (int i = 0; i < bytes.size(); i++) {
            Long thisLong = bytes.get(i);
            thisSeries.add(thisLong);
            if (thisLong < 128) {
                result.add(decodeSingleNumber(thisSeries));
                thisSeries = new ArrayList<>();
            }
        }

        if (result.isEmpty()) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }

        return result;
    }

    private String decodeSingleNumber(List<Long> bytes) {
        String bits = "";
        for (int i = 0; i < bytes.size(); i++) {
            String bitStringOfLong = Long.toBinaryString(bytes.get(i));
            bits += ensureExactly7BitLength(bitStringOfLong);
        }

        return convertBitStringToHex(bits);
    }

    private String ensureExactly7BitLength(String bitString) {
        if (bitString.length() == 8) {
            bitString = bitString.substring(1);
        }

        return String.format("%1$7s", bitString).replace(' ', '0');
    }

    private String convertBitStringToHex(String bits) {
        String prefix = "0x";
        return prefix + Long.toHexString(Long.parseUnsignedLong(bits, 2));
    }
}
