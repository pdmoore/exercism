class Clock {

    private final int hours;
    private final int minutes;

    Clock(int hours, int minutes) {
        int totalMinutes = hours * 60 + minutes;
        int hoursPortion = (totalMinutes / 60) % 24;
        int minutesPortion = totalMinutes % 60;
        if (minutesPortion < 0) {
            minutesPortion = 60 + minutesPortion;
            hoursPortion -= 1;
        }
        if (hoursPortion < 0) {
            hoursPortion = 24 + hoursPortion;
        }
        this.hours = hoursPortion;
        this.minutes = minutesPortion;
    }

    void add(int minutes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}