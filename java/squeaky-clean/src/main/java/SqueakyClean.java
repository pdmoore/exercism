class SqueakyClean {
    static String clean(String identifier) {
        identifier = identifier.replaceAll(" ", "_");

        // stream the string as char/codepoint
        // call a local conversion method
        // space -> underscore
        // isISOControl -> "CTRL"
        // dash -> nothing
        // !isCharacter -> nothing

        return identifier;
    }
}
