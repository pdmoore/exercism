class Leap {

    boolean isLeapYear(int year) {

        return isDivisibleBy(year, 400) || ((isDivisibleBy(year, 4)) && !(isDivisibleBy(year, 100)));
    }

    private boolean isDivisibleBy(int year, int i) {
        return year % i == 0;
    }

}
