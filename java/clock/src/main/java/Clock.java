class Clock {

    private int totalMinutes;

    public Clock(int hours, int minutes) {
        this.add(hours * 60 + minutes);
    }

    public void add(int minutes) {
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
    public boolean equals(Object other) {
        // No tests for checking if obj is null, not a Clock, or this same Clock
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}