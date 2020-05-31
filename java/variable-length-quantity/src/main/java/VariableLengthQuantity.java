import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class VariableLengthQuantity {

    private static final int VLQ_BYTE_LENGTH = 7;
    public static final long SET_BIT_7 = 128;
    public static final String HEX_PREFIX = "0x";
    public static final int LARGEST_7_BIT_NUMBER = 128;

    List<String> encode(List<Long> numbers) {
        return numbers.stream()
                .map(this::encodeSingleNumber)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> encodeSingleNumber(Long number) {
        List<String> vlqBytes = new ArrayList<>();

        vlqBytes.add(convertLeftmostBitsToHex(getNext7BitsOf(number)));
        number >>= VLQ_BYTE_LENGTH;

        while (number > 0) {
            vlqBytes.add(convertLeftmostBitsToHex(SET_BIT_7 | (getNext7BitsOf(number))));
            number >>= VLQ_BYTE_LENGTH;
        }

        Collections.reverse(vlqBytes);
        return vlqBytes;
    }

    private long getNext7BitsOf(Long number) {
        return number & 0x7Fl;
    }

    private String convertLeftmostBitsToHex(long l) {
        return HEX_PREFIX + Long.toHexString(l);
    }

    // encode(List<Long>) ==> encodeSingleNumber(Long) returns List<String>
    // decode(List<Long>) ==> decodeSingleNumber(List<Long>) returns String

    List<String> decode(List<Long> SevenBitBytes) {
        ArrayList<ArrayList<Long>> temp = foo(SevenBitBytes);

        List<String> result = temp.stream()
                .map(this::decodeSingleNumber)
                .collect(Collectors.toList());

        return result;
    }

    private ArrayList<ArrayList<Long>> foo(List<Long> bytes) {
        ArrayList<ArrayList<Long>> allEncodedVLQs = new ArrayList<ArrayList<Long>>();

        ArrayList<Long> BytesInASingleVLQ = new ArrayList<>();
        for (int i = 0; i < bytes.size(); i++) {
            Long sevenBitByte = bytes.get(i);
            BytesInASingleVLQ.add(sevenBitByte);

            if (sevenBitByte < LARGEST_7_BIT_NUMBER) {
                allEncodedVLQs.add(BytesInASingleVLQ);
                BytesInASingleVLQ = new ArrayList<>();
            }
        }

        if (allEncodedVLQs.isEmpty()) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }
        return allEncodedVLQs;
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
        return HEX_PREFIX + Long.toHexString(Long.parseUnsignedLong(bits, 2));
    }
}
