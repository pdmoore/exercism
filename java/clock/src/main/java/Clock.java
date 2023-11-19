class Clock {

    private final int hours;
    private final int minutes;

    Clock(int hours, int minutes) {
        int hoursOver60Minutes = minutes / 60;
        this.hours = hours % 24 + hoursOver60Minutes;
        this.minutes = minutes % 60;
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