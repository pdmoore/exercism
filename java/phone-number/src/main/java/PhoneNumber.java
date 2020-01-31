public class PhoneNumber {

    private static final String wrongLengthExceptionMessage = "incorrect number of digits";


    private final String phoneNumber;

    public PhoneNumber(String rawInput) {
        phoneNumber = cleanUp(rawInput);

        if (phoneNumber.length() < 10) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        }

    }

    private String cleanUp(String rawInput) {
        return rawInput.replaceAll("[( )\\.()-]", "");
    }

    public String getNumber() {
        return phoneNumber;
    }
}
