public class SpiralMatrixBuilder {

    public Integer[][] buildMatrixOfSize(int size) {
        //TODO - refactor away these special cases
        if (size == 0) {
            return new Integer[0][];
        } else if (size == 1) {
            return new Integer[][] { {1} };
        }

        Integer[][] matrix;
        matrix = new Integer[size][size];

        //TODO - started building a spiral approach of for loops
        // Only works for size 2 right now
        // need to consider squeezing the boundaries each pass
        // following this thinking....across to right, down to bottom, across to left, up to top


        // ACROSS TO RIGHT
        int counter = 1;
        for (int i = 0; i < size; i++) {
            matrix[0][i] = counter++;
        }

        // DOWN TO BOTTOM
        for (int i = 1; i < size; i++) {
            matrix[i][size - 1] = counter ++;
        }

        // ACROSS TO LEFT
        for (int i = size - 1; i >= 0; i--) {
            matrix[1][i] = counter++;
        }



        return matrix;
    }
}
