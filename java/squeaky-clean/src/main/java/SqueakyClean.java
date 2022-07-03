import java.nio.charset.Charset;

class SqueakyClean {

    public static final String REPLACE_SPACE_WITH_UNDERSCORE = "_";
    public static final String REPLACE_CONTROL_CHARACTERS_WITH_CTRL = "CTRL";

    static String clean(String identifier) {
        StringBuffer sb = new StringBuffer();
        boolean convertToCamel = false;
        for (int c :
                identifier.toCharArray()) {

            if (beginsKebabCase(c)) {
                convertToCamel = true;
            } else if (isGreekLowerCase(c)) {
                continue;
            } else if (Character.isLetter(c)) {
                if (convertToCamel) {
                    sb.append(Character.toChars(Character.toUpperCase(c)));
                    convertToCamel = false;
                } else {
                    sb.append(Character.toChars(c));
                }
            } else if (Character.isSpaceChar(c)) {
                sb.append(REPLACE_SPACE_WITH_UNDERSCORE);
            } else if (Character.isISOControl(c)) {
                sb.append(REPLACE_CONTROL_CHARACTERS_WITH_CTRL);
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
