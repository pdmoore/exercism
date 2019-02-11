class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String isbnWithoutDashes = stripDashes(stringToVerify);

        if (isbnWithoutDashes.isEmpty() ||
            isbnWithoutDashes.length() != 10) return false;

        if (containsInvalidCharacters(isbnWithoutDashes)) return false;

        return isValidIsbn(isbnWithoutDashes);
    }

    private boolean isValidIsbn(String isbn) {
        int sum = 0;
        for (int i = 0; i < isbn.length() - 1; i++) {
            sum += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
        }

        char checkChar = isbn.charAt(isbn.length() - 1);
        if (checkChar == 'X') {
            sum += 10;
        } else {
            sum += Character.getNumericValue(checkChar);
        }

        return (sum % 11) == 0;
    }

    private String stripDashes(String stringToVerify) {
        String copy = stringToVerify;
        return copy.replace("-", "");
    }

    private boolean containsInvalidCharacters(String isbn) {
        Character lastCharacter = isbn.charAt(isbn.length() - 1);
        if (Character.isAlphabetic(lastCharacter) && !lastCharacter.equals('X')) return true;

        String isbnWithoutCheckDigit = isbn.substring(0, isbn.length() - 2);
        for (Character c:
             isbnWithoutCheckDigit.toCharArray()) {
            if (Character.isAlphabetic(c)) return true;
        }
        return false;
    }

}
