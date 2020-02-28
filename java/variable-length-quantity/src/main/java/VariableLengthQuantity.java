import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {

        //TODO - loop through list of numbers and perform translation operation, appending to answer


        // TODO - instead of numbers get(0), translate number and return List of strings

        Long encodeThis = numbers.get(0);

        String answer;
        List<String> answer2 = new ArrayList<>();
        if (encodeThis < 128) {
            answer = String.format("0x%01x", encodeThis);
            answer2.add(answer);
        } else {
            answer = "0x81";
            answer2.add(answer);
            answer = "0x0";
            answer2.add(answer);
        }


        return answer2;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
