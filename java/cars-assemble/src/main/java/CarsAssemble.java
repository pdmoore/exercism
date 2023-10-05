public class CarsAssemble {

    private final int BASE_PRODUCTION_RATE = 221;

    public double productionRatePerHour(int speed) {

        int successRate = 100;
        double percent = 1.0;
        if (speed == 10) {
            successRate = 77;
        } else if (speed == 9) {
            successRate = 80;
        } else if (speed >= 5) {
            successRate = 90;
        }

        return (BASE_PRODUCTION_RATE * speed * successRate / 100.0);
    }

    public int workingItemsPerMinute(int speed) {

        int successRate = 100;
        if (speed == 10) {
            successRate = 77;
        } else if (speed == 9) {
            successRate = 80;
        } else if (speed >= 5) {
            successRate = 90;
        }

        return (int) (productionRatePerHour(speed) / 60);
/*
1 to 4: 100% success rate.
5 to 8: 90% success rate.
9: 80% success rate.
10: 77% success rate.
 */

    }
}
