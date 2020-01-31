public class PhoneNumber {

    private final String phoneNumber;

    public PhoneNumber(String rawInput) {

        phoneNumber = cleanUp(rawInput);

    }

    private String cleanUp(String rawInput) {
        String cleanUp = rawInput;

        cleanUp = rawInput.replace("(", "");
        cleanUp = cleanUp.replace(")", "");
        cleanUp = cleanUp.replace(" ", "");
        cleanUp = cleanUp.replace(".", "");
        cleanUp = cleanUp.replace("-", "");

        return cleanUp;
    }

    public String getNumber() {
        return phoneNumber;
    }
}
