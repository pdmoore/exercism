public class PhoneNumber {

    private static final String wrongLengthExceptionMessage = "incorrect number of digits";
    private static final String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "11 digits must start with 1";


    private final String phoneNumber;

    public PhoneNumber(String rawInput) {
        String clean = cleanUp(rawInput);

        if (clean.length() < 10) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        } else if (clean.length() > 10) {
            if (clean.charAt(0) != '1') {
                throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
            }
            clean = clean.substring(1);
        }

        phoneNumber = clean;

    }

    private String cleanUp(String rawInput) {
        return rawInput.replaceAll("[( )\\.()-]", "");
    }

    public String getNumber() {
        return phoneNumber;
    }
}
