public class SpiralMatrixBuilder {

    enum POPULATE_NEXT_CELL { GO_RIGHT, GO_DOWN, GO_LEFT, GO_UP };

    public Integer[][] buildMatrixOfSize(int size) {
        Integer[][] matrix;
        matrix = new Integer[size][size];
        POPULATE_NEXT_CELL direction = POPULATE_NEXT_CELL.GO_RIGHT;

        int i = 0;
        int j = 0;
        int counter = 1;
        while (counter <= (size * size)) {
            matrix[i][j] = counter++;

            switch (direction) {
                case GO_RIGHT: {
                    j++;
                    if ((j > size - 1) || matrix[i][j] != null) {
                        j--;
                        i++;
                        direction = POPULATE_NEXT_CELL.GO_DOWN;
                    }
                    break;
                }
                case GO_DOWN: {
                    i++;
                    if (i > size - 1 || matrix[i][j] != null) {
                        i--;
                        j--;
                        direction = POPULATE_NEXT_CELL.GO_LEFT;
                    }
                    break;
                }
                case GO_LEFT: {
                    j--;
                    if (j < 0 || matrix[i][j] != null) {
                        j++;
                        i--;
                        direction = POPULATE_NEXT_CELL.GO_UP;
                    }
                    break;
                }
                case GO_UP:
                    i--;
                    if ((i < 0) || (matrix[i][j] != null)) {
                        i++;
                        j++;
                        direction = POPULATE_NEXT_CELL.GO_RIGHT;
                    }
                    break;
            }
        }

        return matrix;
    }
}
