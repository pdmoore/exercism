import java.util.concurrent.ConcurrentHashMap;

public class PhoneNumber {

    private static final String wrongLengthExceptionMessage = "incorrect number of digits";
    private static final String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "11 digits must start with 1";
    private static final String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static final String illegalCharacterExceptionMessage = "letters not permitted";


    private final String phoneNumber;

    public PhoneNumber(String rawInput) {
        String clean = cleanUp(rawInput);

        if (nonDigits(clean)) {
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);
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

    private boolean nonDigits(String phoneNumber) {
        return phoneNumber.chars().anyMatch(c -> !Character.isDigit(c));
    }

    private String cleanUp(String rawInput) {
        return rawInput.replaceAll("[+( )\\.()-]", "");
    }

    public String getNumber() {
        return phoneNumber;
    }
}
