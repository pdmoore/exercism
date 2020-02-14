public class SpiralMatrixBuilder {

    public Integer[][] buildMatrixOfSize(int size) {
        if (size == 0) {
            return new Integer[0][];
        } else if (size == 1) {
            return new Integer[][] { {1} };
        }

        Integer[][] matrix;
        matrix = new Integer[size][size];

        int counter = 1;
        for (int i = 0; i < size; i++) {
            matrix[0][i] = counter++;
        }
//        matrix[0][0] = 1;
//        matrix[0][1] = 2;


        matrix[1][0] = 4;
        matrix[1][1] = 3;



        return matrix;
    }
}
