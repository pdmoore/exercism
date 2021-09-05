public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int actualMinutesInOven) {
        return 40 - actualMinutesInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return 2 * numberOfLayers;
    }

    public boolean totalTimeInMinutes(int i, int i1) {
        return false;
    }
}
