public class RunLengthEncoding {


    public String encode(String original) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < original.length()) {

            char thisChar = original.charAt(i);
            int j = i + 1;

            while (j < original.length() && (original.charAt(j) == thisChar)) {
                j++;
            }

            if (j == i + 1) {
                sb.append(original.charAt(i));
                i++;

            } else {
                sb.append(j - i);
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
