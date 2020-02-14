public class SpiralMatrixBuilder {

    public Integer[][] buildMatrixOfSize(int size) {
        if (size == 0) {
            return new Integer[0][];
        } else if (size == 1) {
            return new Integer[][] { {1} };
        }

        Integer[][] matrix;
        matrix = new Integer[size][size];

        //TODO - started building a sprial approach of for loops
        // Only works for size 2 right now
        // need to consider squeezing the boundaries each pass
        int counter = 1;
        for (int i = 0; i < size; i++) {
            matrix[0][i] = counter++;
        }


        for (int i = size - 1; i >= 0; i--) {
            matrix[1][i] = counter++;
        }



        return matrix;
    }
}
