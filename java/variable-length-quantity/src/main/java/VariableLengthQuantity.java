import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class VariableLengthQuantity {

    private static final String LAST_BYTE_IN_SERIES = "0";
    private static final String PRECEDING_BYTE_IN_SERIES = "1";

    List<String> encode(List<Long> numbers) {

        return numbers.stream()
                .map(this::encodeSingleNumber)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> encodeSingleNumber(Long number) {
        List<String> vlqBytes = new ArrayList<>();

        boolean lastByte = true;
        String remainingBits = Long.toBinaryString(number);
        while (!remainingBits.isEmpty()) {
            String bits0to6;
            if (remainingBits.length() < 7) {
                bits0to6 = ensureExactly7BitLength(remainingBits);
            } else {
                bits0to6 = remainingBits.substring(remainingBits.length() - 7);
            }

            // Hmmmmm....the first time it is always '0', the rest of the time '1'.
            // Some other way to accomplish this apart from the lastByte flag?
            String bit7 = PRECEDING_BYTE_IN_SERIES;
            if (lastByte) {
                bit7 = LAST_BYTE_IN_SERIES;
                lastByte = false;
            }
            String SevenBitByte = bit7 + bits0to6;

            String bitString = String.format("0x%01x", Integer.parseInt(SevenBitByte, 2));
            vlqBytes.add(bitString);

            int endIndex = Math.max(0, remainingBits.length() - 7);
            remainingBits = remainingBits.substring(0, endIndex);
        }

        Collections.reverse(vlqBytes);
        return vlqBytes;
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
