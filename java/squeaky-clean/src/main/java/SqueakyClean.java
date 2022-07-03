import java.nio.charset.Charset;

class SqueakyClean {
    static String clean(String identifier) {
        // stream the string as char/codepoint
        // call a local conversion method
        // space -> underscore
        // isISOControl -> "CTRL"
        // dash -> nothing
        // !isCharacter -> nothing

        StringBuffer sb = new StringBuffer();
        boolean convertToCamel = false;
        for (int c :
                identifier.codePoints().toArray()) {

            if (c == '-') {
                convertToCamel = true;
            } else if (c >= 'α' && c <= 'ω') {
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
}
