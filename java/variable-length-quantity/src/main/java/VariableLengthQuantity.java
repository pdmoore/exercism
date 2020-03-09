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

        // Guard clause to handle small numbers
        if (number < 128) {
            String numberAsBits = Long.toBinaryString(number);
            numberAsBits = String.format("%1$7s", numberAsBits).replace(' ', '0');
            String bitString = String.format("0x%01x", Integer.parseInt(numberAsBits, 2));
            numberEncoding.add(bitString);

            return numberEncoding;
        }


        Stack<String> vlqNumbers = new Stack<>();

        String numberAsBits = Long.toBinaryString(number);

        // TODO revist this logic - there's some minor duplication and it's very verbose
        boolean firstTime = true;
        while (!numberAsBits.isEmpty()) {

            if (numberAsBits.length() < 7) {
                numberAsBits = "1" + String.format("%1$7s", numberAsBits).replace(' ', '0');
                String bitString = String.format("0x%01x", Integer.parseInt(numberAsBits, 2));
                vlqNumbers.push(bitString);
                numberAsBits = "";
            } else {
                String rightSide = numberAsBits.substring(numberAsBits.length() - 7);
                if (firstTime) {
                    rightSide = "0" + rightSide;
                    firstTime = false;
                } else {
                    rightSide = "1" + rightSide;
                }
                String bitString = String.format("0x%01x", Integer.parseInt(rightSide, 2));
                vlqNumbers.push(bitString);
                numberAsBits = numberAsBits.substring(0, numberAsBits.length() - 7);
            }
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
