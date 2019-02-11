class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

        String numberAsString = Integer.toString(numberToCheck);
        int power = numberAsString.length();
        int sum = 0;
        for (int i = 0; i < numberAsString.length(); i++) {
            int currentDigit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            sum += (int) Math.pow(currentDigit, power);
        }

        return sum == numberToCheck;
	}

}
