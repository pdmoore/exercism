import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {



        List<String> encoding = new ArrayList<>();

        //TODO - loop through list of numbers and perform translation operation, appending to answer
        Long encodeThis = numbers.get(0);

        // TODO - instead of numbers get(0), translate number and return List of strings

        String answer;
        if (encodeThis < 128) {
            answer = String.format("0x%01x", encodeThis);
            encoding.add(answer);
        } else {
            List<String> largeNumberEncoding = new ArrayList<>();
            largeNumberEncoding.add("0x81");
            largeNumberEncoding.add("0x0");

            encoding.addAll(largeNumberEncoding);
        }




        return encoding;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
