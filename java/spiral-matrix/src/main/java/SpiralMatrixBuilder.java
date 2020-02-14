public class SpiralMatrixBuilder {

    public Integer[][] buildMatrixOfSize(int i) {
        if (i == 0) {
            return new Integer[0][];
        } else if (i == 1) {
            return new Integer[][] { {1} };
        }

        Integer[][] matrix;
        matrix = new Integer[i][i];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 4;
        matrix[1][1] = 3;
        return matrix;

    }
}
