import java.math.BigInteger;

class Grains {

    private static final String WRONG_SQUARE_MESSAGE = "square must be between 1 and 64";

    BigInteger computeNumberOfGrainsOnSquare(final int square) {
        if ((square < 1) || (square > 64)) {
            throw new IllegalArgumentException(WRONG_SQUARE_MESSAGE);
        }

        return (BigInteger.valueOf(2)).pow(square - 1);
    }

    BigInteger computeTotalNumberOfGrainsOnBoard() {
        BigInteger totalGrains = BigInteger.ZERO;
        for (int i = 1; i <= 64; i++) {
            totalGrains = totalGrains.add(computeNumberOfGrainsOnSquare(i));
        }

        return totalGrains;
    }

}
