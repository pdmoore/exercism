class LuhnValidator {

    boolean isValid(String candidate) {
        String justDigits = removeWhitespace(candidate);

        if (notLongEnough(justDigits) || containsNonNumbers(justDigits)) return false;

        int luhnChecksum = calculateLuhnChecksum(justDigits);
        return luhnChecksum % 10 == 0;
    }

    private String removeWhitespace(String candidate) {
        return candidate.replaceAll("\\s", "");
    }

    private boolean notLongEnough(String justDigits) {
        return justDigits.length() <= 1;
    }

    private boolean containsNonNumbers(String justDigits) {
        return justDigits.matches("^[0-9]+$") == false;
    }

    private int calculateLuhnChecksum(String digits) {
        int checksum = 0;

        for (int i = digits.length() - 1; i >= 0; i--) {
            int digitValue = digits.charAt(i) - '0';

            if (((digits.length() - i) % 2) == 0) {
                digitValue += digitValue;
                if (digitValue > 9) digitValue -= 9;
            }

            checksum += digitValue;
        }

        return checksum;
    }
}
