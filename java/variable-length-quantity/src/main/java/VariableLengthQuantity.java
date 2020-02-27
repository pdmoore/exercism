import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {

        String answer = String.format("0x%01X", numbers.get(0));

        List<String> answer2 = new ArrayList<>();
        answer2.add(answer);

        return answer2;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
