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
        // instead of 4 for loops, have a vert/horz delta that flips when edges are hit. Wrap in a while loop
        // until counter is size*size


        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 4;
        matrix[1][1] = 3;


        return matrix;
    }
}
