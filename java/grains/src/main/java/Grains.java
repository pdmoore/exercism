import java.math.BigInteger;

class Grains {

    private static final String WRONG_SQUARE_MESSAGE = "square must be between 1 and 64";
    private static final int BOARD_SIZE = 8;
    private static final int NUMBER_OF_SQUARES = BOARD_SIZE * BOARD_SIZE;

    BigInteger computeNumberOfGrainsOnSquare(final int squareNumber) {
        if ((squareNumber < 1) || (squareNumber > NUMBER_OF_SQUARES)) {
            throw new IllegalArgumentException(WRONG_SQUARE_MESSAGE);
        }

        return (BigInteger.valueOf(2)).pow(squareNumber - 1);
    }

    BigInteger computeTotalNumberOfGrainsOnBoard() {
        BigInteger totalGrains = (BigInteger.valueOf(2)).pow(NUMBER_OF_SQUARES).subtract(BigInteger.ONE);
        return totalGrains;
    }

}
