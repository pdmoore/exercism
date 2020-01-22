public class RunLengthEncoding {


    public String encode(String original) {

        // for each character in the original string

        // if next character is same as this character,
          // increment count
          // look at the next character
        //if count > 0
          // emit count and single character
        // else
          // emit single character

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < original.length()) {

            char thisChar = original.charAt(i);
            int j = i + 1;

            int runCount = 1;
            while (j < original.length() && (original.charAt(j) == thisChar)) {
                runCount++;
                j++;
            }

            if (runCount == 1) {
                sb.append(original.charAt(i));
                i++;

            } else {
                sb.append(runCount);
                sb.append(original.charAt(i));
                i = j;
            }
        }



        return sb.toString();
    }

    public String decode(String s) {
        throw new UnsupportedOperationException("decode not implemented yet");
    }
}
