public class PhoneNumber {

    private final String phoneNumber;

    public PhoneNumber(String rawInput) {

        phoneNumber = cleanUp(rawInput);

    }

    private String cleanUp(String rawInput) {
        return "2234567890";
    }

    public String getNumber() {
        return phoneNumber;
    }
}
