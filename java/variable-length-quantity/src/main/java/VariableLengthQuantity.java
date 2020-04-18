import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {

        return numbers.stream()
                .map(this::encodeThisNumber)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> encodeThisNumber(Long number) {

        Stack<String> vlqNumbers = new Stack<>();

        boolean firstTime = true;
        String numberAsBits = Long.toBinaryString(number);
        while (!numberAsBits.isEmpty()) {
            String thisNumber;

            // TODO can't extract entire if/else
            // can extract intention revealing methods for each branch
            if (number < 128) {
                thisNumber = String.format("%1$7s", numberAsBits).replace(' ', '0');
            } else if (numberAsBits.length() < 7) {
                thisNumber = "1" + String.format("%1$7s", numberAsBits).replace(' ', '0');
            } else {
                String prefix = "1";
                if (firstTime) {
                    prefix = "0";
                    firstTime = false;
                }
                String rightSide = numberAsBits.substring(numberAsBits.length() - 7);
                thisNumber = prefix + rightSide;
            }

            String bitString = String.format("0x%01x", Integer.parseInt(thisNumber, 2));
            vlqNumbers.push(bitString);

            int endIndex = Math.max(0, numberAsBits.length() - 7);
            numberAsBits = numberAsBits.substring(0, endIndex);
        }

        List<String> numberEncoding = new ArrayList<>();
        while (!vlqNumbers.empty()) {
            numberEncoding.add(vlqNumbers.pop());
        }

        return numberEncoding;
    }

    List<String> decode(List<Long> bytes) {
        List<String> result = new ArrayList<>();
        String bits = "";
        for (int i = 0; i < bytes.size(); i++) {
            String bitString = ensure7Bits(Long.toBinaryString(bytes.get(i)));
            bits += bitString;
        }

        result.add(convertBitStringToHex(bits));
        return result;
    }

    private String ensure7Bits(String bitString) {
        if (bitString.length() == 8) {
            bitString = bitString.substring(1);
        }
        while (bitString.length() != 7) {
            bitString += "0";
        }
        return bitString;
    }

    private String convertBitStringToHex(String bits) {
        String prefix = "0x";
        return prefix + Long.toHexString(Long.parseUnsignedLong(bits, 2));
    }
}
