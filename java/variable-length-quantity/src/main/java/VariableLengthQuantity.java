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
            while (!numberAsBits.isEmpty()) {
                if (numberAsBits.length() > 7) {
                    String rightSide = numberAsBits.substring(numberAsBits.length() - 7);
                    vlqNumbers.push(String.format("0x%01x", Integer.parseInt(rightSide, 2)));
                    numberAsBits = numberAsBits.substring(0, numberAsBits.length() - 7);
                } else {
                    numberAsBits = "1" + String.format("%1$7s", numberAsBits).replace(' ', '0');
                    vlqNumbers.push(String.format("0x%01x", Integer.parseInt(numberAsBits, 2)));
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
