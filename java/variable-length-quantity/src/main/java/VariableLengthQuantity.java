import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {



        List<String> encoding = new ArrayList<>();

        //TODO - loop through list of numbers and perform translation operation, appending to answer
        Long encodeThis = numbers.get(0);


        encoding.addAll(encodeThisNumber(encodeThis));


        return encoding;
    }

    private List<String> encodeThisNumber(Long number) {
        // TODO - instead of numbers get(0), translate number and return List of strings
        List<String> numberEncoding = new ArrayList<>();
        if (number < 128) {
            numberEncoding.add(String.format("0x%01x", number));
        } else {
            numberEncoding.add("0x81");
            numberEncoding.add("0x0");
        }
        return numberEncoding;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
