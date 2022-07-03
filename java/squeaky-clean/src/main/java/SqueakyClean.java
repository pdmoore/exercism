import java.nio.charset.Charset;

class SqueakyClean {
    static String clean(String identifier) {
        StringBuffer sb = new StringBuffer();
        boolean convertToCamel = false;
        for (int c :
                identifier.codePoints().toArray()) {

            if (beginsKebabCase(c)) {
                convertToCamel = true;
            } else if (isGreekLowerCase(c)) {
                // ignore Greek lower case
            } else if (Character.isLetter(c)) {
                if (convertToCamel) {
                    sb.append(Character.toChars(Character.toUpperCase(c)));
                    convertToCamel = false;
                } else {
                    sb.append(Character.toChars(c));
                }
            } else if (Character.isSpaceChar(c)) {
                sb.append("_");
            } else if (Character.isISOControl(c)) {
                sb.append("CTRL");
            }
        }

        return sb.toString();
    }

    private static boolean isGreekLowerCase(int c) {
        return c >= 'α' && c <= 'ω';
    }

    private static boolean beginsKebabCase(int c) {
        return c == '-';
    }
}
