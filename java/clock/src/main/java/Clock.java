class Clock {

    private int totalMinutes;

    Clock(int hours, int minutes) {
        int initialMinutes = hours * 60 + minutes;
        int hoursPortion = (initialMinutes / 60) % 24;
        int minutesPortion = initialMinutes % 60;
        if (minutesPortion < 0) {
            minutesPortion = 60 + minutesPortion;
            hoursPortion -= 1;
        }
        if (hoursPortion < 0) {
            hoursPortion = 24 + hoursPortion;
        }
        totalMinutes = hoursPortion * 60 + minutesPortion;
    }

    void add(int minutes) {
        totalMinutes += minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", getHours(), getMinutes());
    }

    private int getMinutes() {
        return Math.floorMod(totalMinutes, 60);
    }

    private int getHours() {
        return Math.floorMod(Math.floorDiv(totalMinutes,  60), 24);
    }

    @Override
    public boolean equals(Object obj) {
        // No tests for checking if obj is null, not a Clock, or this same Clock
        return this.totalMinutes == ((Clock)obj).totalMinutes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return 31 * hash + totalMinutes;
    }
}