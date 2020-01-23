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

    public String decode(String encoded) {

        StringBuilder decoded = new StringBuilder();

        int i = 0;
        while (i < encoded.length()) {

            Character thisChar = encoded.charAt(i);
            if (!Character.isDigit(thisChar)) {
                decoded.append(encoded.charAt(i));
                ++i;
            } else {
                int repeatCount = grabCountFrom(i, encoded);
                char charToRepeat = encoded.charAt(i + String.valueOf(repeatCount).length());
                for (int j = 0; j < repeatCount; j++) {
                    decoded.append(charToRepeat);
                }

                // TODO - need to take into account length of repeatCount
                i += String.valueOf(repeatCount).length() + 1;
            }

        }

        return decoded.toString();
    }

    private int grabCountFrom(int i, String encoded) {
        for (int j = i + 1; j <= encoded.length(); j++) {
            if (!Character.isDigit(encoded.charAt(j))) {
                String digit = encoded.substring(i, j);
                return Integer.parseInt(digit);
            }
        }

        return 1;
    }
}
