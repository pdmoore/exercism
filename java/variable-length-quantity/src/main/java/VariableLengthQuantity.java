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

            System.out.println(number + ": " + Long.toBinaryString(number));
            String binaryLong = Long.toBinaryString(number);
            Stack<String> vlqNumbers = new Stack<>();

            // Going from right to left
            // if there are 7 or fewer digits left, pad and set left most bit
            // otherwise push the number as is

            String numberAsBits = Long.toBinaryString(number);

            String rightSide = numberAsBits.substring(numberAsBits.length() - 7, numberAsBits.length());
            System.out.println("just ganked " + rightSide);
            vlqNumbers.push(String.format("0x%01x", Integer.parseInt(rightSide, 2)));

/** Works for double bytes only **/
            numberAsBits = numberAsBits.substring(0, numberAsBits.length() - 7);
            System.out.println("remainder is now: " + numberAsBits);

            // logic works for double-bytes, not for triple, need a loop around the ganking
            // it's less than 7, so set left most bit and pad remainder with 0s
            numberAsBits = "1" + String.format("%1$7s", numberAsBits).replace(' ', '0');

            String format = String.format("0x%01x", Integer.parseInt(numberAsBits, 2));
            vlqNumbers.push(format);
/** end working **/

// CONVERT THE ABOVE INTO A LOOP - process each chunk from right to left, deciding when to add the high bit
//            while (!numberAsBits.isEmpty()) {
//                if (numberAsBits.length() < 7) {
////                    numberAsBits = numberAsBits.substring(0, numberAsBits.length() - 7);
////                    System.out.println("remainder is now: " + numberAsBits);
//
//                    // logic works for double-bytes, not for triple, need a loop around the ganking
//                    // it's less than 7, so set left most bit and pad remainder with 0s
//                    numberAsBits = "1" + String.format("%1$7s", numberAsBits).replace(' ', '0');
//
//                    String format = String.format("0x%01x", Integer.parseInt(numberAsBits, 2));
//                    vlqNumbers.push(format);
//                    numberAsBits = null;
//                } else {
//                    String rightSide = numberAsBits.substring(numberAsBits.length() - 7, numberAsBits.length());
//                    System.out.println("just ganked " + rightSide);
//                    vlqNumbers.push(String.format("0x%01x", Integer.parseInt(rightSide, 2)));
//                    numberAsBits = numberAsBits.substring(0, numberAsBits.length() - 7);
//                }
//            }



            while (!vlqNumbers.empty()) {
                numberEncoding.add(vlqNumbers.pop());
            }

            // (2) similar to hard-coded but uses formatting to generate answer (convert from bits to hex)
//            numberEncoding.add(String.format("0x%01x", Integer.parseInt("10000001", 2)));
//            numberEncoding.add(String.format("0x%01x", Integer.parseInt("00000000", 2)));

            // (1) hard coded answer
//            numberEncoding.add("0x81");
//            numberEncoding.add("0x0");
        }
        return numberEncoding;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
