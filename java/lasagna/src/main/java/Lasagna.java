public class Lasagna {

    public static final int TOTAL_OVEN_MINUTES = 40;
    public static final int MINUTES_PER_LAYER = 2;

    public int expectedMinutesInOven() {
        return TOTAL_OVEN_MINUTES;
    }

    public int remainingMinutesInOven(int actualMinutesInOven) {
        return expectedMinutesInOven() - actualMinutesInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * MINUTES_PER_LAYER;
    }

    public int totalTimeInMinutes(int numberOfLayers, int actualMinutesInOven) {
        return preparationTimeInMinutes(numberOfLayers) + actualMinutesInOven;
    }
}
