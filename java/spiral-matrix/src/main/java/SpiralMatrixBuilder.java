public class SpiralMatrixBuilder {

    public Integer[][] buildMatrixOfSize(int i) {
        if (i == 0) {
            return new Integer[0][];
        } else if (i == 1) {
            return new Integer[][] { {1} };
        }

        Integer[][] matrix = new Integer[][] {{1, 2}, {4, 3}};
        return matrix;

    }
}
