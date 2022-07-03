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
        for (int c :
                identifier.codePoints().toArray()) {


            if (c >= 'α'&& c <= 'ω') {
                // ignore Greek lower case
            } else if (Character.isLetter(c)) {
                sb.append(Character.toChars(c));
            }
            else if (Character.isSpaceChar(c)) {
                sb.append("_");
            } else if (Character.isISOControl(c)) {
                sb.append("CTRL");
            }
        }



        return sb.toString();
    }
}
