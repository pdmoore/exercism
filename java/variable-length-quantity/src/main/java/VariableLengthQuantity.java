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

        // TODO - logic here is similar to first if ( length < 7) of while loop
        // except here we don't leftpad with a "1"
        String numberAsBits = Long.toBinaryString(number);
        Stack<String> vlqNumbers = new Stack<>();

        // TODO revist this logic - there's some minor duplication and it's very verbose
        boolean firstTime = true;
        int endIndex;
        while (!numberAsBits.isEmpty()) {

            if (number < 128 || (numberAsBits.length() < 7)) {
                String prefix = "1";
                if (number < 128) {
                    prefix = "";
                }
                numberAsBits = prefix + String.format("%1$7s", numberAsBits).replace(' ', '0');
                String bitString = String.format("0x%01x", Integer.parseInt(numberAsBits, 2));
                vlqNumbers.push(bitString);
                // clear the string out for the next pass
                endIndex = 0;
//                numberAsBits = numberAsBits.substring(0, endIndex);
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

                endIndex = numberAsBits.length() - 7;
//                numberAsBits = numberAsBits.substring(0, endIndex);
            }
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
