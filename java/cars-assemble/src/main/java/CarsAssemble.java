public class CarsAssemble {

    private final int BASE_PRODUCTION_RATE = 221;

    public double productionRatePerHour(int speed) {
        return BASE_PRODUCTION_RATE * speed;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed);


    }
}
