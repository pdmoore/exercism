public class CarsAssemble {

    private static final int BASE_PRODUCTION_RATE = 221;
    private static final int MINUTES_PER_HOUR = 60;

    public double productionRatePerHour(int speed) {

        double successRate = successRatePercentageFor(speed);

        return (BASE_PRODUCTION_RATE * speed * successRate);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / MINUTES_PER_HOUR);
    }

    private static double successRatePercentageFor(int speed) {
        int successRate = 100;
        if (speed == 10) {
            successRate = 77;
        } else if (speed == 9) {
            successRate = 80;
        } else if (speed >= 5) {
            successRate = 90;
        }
        return successRate / 100.0;
    }
}
