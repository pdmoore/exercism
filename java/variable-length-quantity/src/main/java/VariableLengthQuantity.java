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

        List<String> numberEncoding = new ArrayList<>();

        String numberAsBits = Long.toBinaryString(number);
        Stack<String> vlqNumbers = new Stack<>();

        boolean firstTime = true;
        while (!numberAsBits.isEmpty()) {
            String thisNumber;

            // TODO revist this logic - there's some minor duplication and it's very verbose
            if (number < 128 || (numberAsBits.length() < 7)) {
                String prefix = "1";
                if (number < 128) {
                    prefix = "";
                }
                thisNumber = prefix + String.format("%1$7s", numberAsBits).replace(' ', '0');
            } else {
                String rightSide = numberAsBits.substring(numberAsBits.length() - 7);
                if (firstTime) {
                    rightSide = "0" + rightSide;
                    firstTime = false;
                } else {
                    rightSide = "1" + rightSide;
                }
                thisNumber = rightSide;
            }

            String bitString = String.format("0x%01x", Integer.parseInt(thisNumber, 2));
            vlqNumbers.push(bitString);

            int endIndex = Math.max(0, numberAsBits.length() - 7);
            numberAsBits = numberAsBits.substring(0, endIndex);
        }

        while (!vlqNumbers.empty()) {
            numberEncoding.add(vlqNumbers.pop());
        }

        return numberEncoding;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
