public class PhoneNumber {

    private static final String wrongLengthExceptionMessage = "incorrect number of digits";
    private static final String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "11 digits must start with 1";
    private static final String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static final String illegalCharacterExceptionMessage = "letters not permitted";
    private static final String illegalPunctuationExceptionMessage = "punctuations not permitted";


    private final String phoneNumber;

    public PhoneNumber(String rawInput) {
        String clean = cleanUp(rawInput);

        if (hasAlphabeticCharacters(clean)) {
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);
        }

        if (hasPunctuation(clean)) {
            throw new IllegalArgumentException(illegalPunctuationExceptionMessage);
        }

        if (clean.length() < 10) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        } else if (clean.length() > 11) {
            throw new IllegalArgumentException(moreThan11DigitsExceptionMessage);
        } else if (clean.length() > 10) {
            if (clean.charAt(0) != '1') {
                throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
            }
            clean = clean.substring(1);
        }

        phoneNumber = clean;

    }

    private boolean hasPunctuation(String phoneNumber) {
        return phoneNumber.chars().anyMatch(c -> !Character.isDigit(c));
    }

    private boolean hasAlphabeticCharacters(String phoneNumber) {
        return phoneNumber.chars().anyMatch(c -> Character.isAlphabetic(c));
    }

    private String cleanUp(String rawInput) {
        return rawInput.replaceAll("[+( )\\.()-]", "");
    }

    public String getNumber() {
        return phoneNumber;
    }
}
