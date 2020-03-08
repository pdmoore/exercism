import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {


        List<String> encoding = new ArrayList<>();

        //TODO - loop through list of numbers and perform translation operation, appending to answer
        Long encodeThis = numbers.get(0);


        encoding.addAll(encodeThisNumber(encodeThis));


        return encoding;
    }

    private List<String> encodeThisNumber(Long number) {
        List<String> numberEncoding = new ArrayList<>();
        if (number < 128) {
            numberEncoding.add(String.format("0x%01x", number));
        } else {

            Stack<String> vlqNumbers = new Stack<>();

            String numberAsBits = Long.toBinaryString(number);

            // Might be attach a '1' to everything but the rightmost?
            boolean firstTime = true;
            while (!numberAsBits.isEmpty()) {
                //modify so that first number gets "0" prepended, remainder get 1
                if (numberAsBits.length() > 7) {
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
                } else {
                    numberAsBits = "1" + String.format("%1$7s", numberAsBits).replace(' ', '0');
                    String bitString = String.format("0x%01x", Integer.parseInt(numberAsBits, 2));
                    vlqNumbers.push(bitString);
                    numberAsBits = "";
                }
            }

            while (!vlqNumbers.empty()) {
                numberEncoding.add(vlqNumbers.pop());
            }

        }
        return numberEncoding;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
