public class PhoneNumber {

    private static final String wrongLengthExceptionMessage = "incorrect number of digits";
    private static final String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "11 digits must start with 1";


    private final String phoneNumber;

    public PhoneNumber(String rawInput) {
        phoneNumber = cleanUp(rawInput);

        if (phoneNumber.length() < 10) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        } else if (phoneNumber.length() > 10) {
            throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        }

    }

    private String cleanUp(String rawInput) {
        return rawInput.replaceAll("[( )\\.()-]", "");
    }

    public String getNumber() {
        return phoneNumber;
    }
}
