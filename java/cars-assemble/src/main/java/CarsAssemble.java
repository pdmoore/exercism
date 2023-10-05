public class CarsAssemble {

    private final int BASE_PRODUCTION_RATE = 221;

    public double productionRatePerHour(int speed) {
        return BASE_PRODUCTION_RATE * speed;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
/*
1 to 4: 100% success rate.
5 to 8: 90% success rate.
9: 80% success rate.
10: 77% success rate.
 */

    }
}
