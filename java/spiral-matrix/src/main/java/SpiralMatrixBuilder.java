public class SpiralMatrixBuilder {

    enum POPULATE_NEXT_CELL { GO_RIGHT, GO_DOWN, GO_LEFT, GO_UP };

    public Integer[][] buildMatrixOfSize(int size) {
        //TODO - refactor away these special cases
        if (size == 0) {
            return new Integer[0][];
        } else if (size == 1) {
            return new Integer[][] { {1} };
        }

        Integer[][] matrix;
        matrix = new Integer[size][size];
        int counter = 1;
        POPULATE_NEXT_CELL direction = POPULATE_NEXT_CELL.GO_RIGHT;

        int i = 0;
        int j = 0;
        while (counter <= (size * size)) {
            matrix[i][j] = counter++;

            switch (direction) {
                case GO_RIGHT: {
                    j++;
                    if (j > size - 1) {
                        j--;
                        i++;
                        direction = POPULATE_NEXT_CELL.GO_DOWN;
                    }
                    break;
                }
                case GO_DOWN: {
                    i++;
                    if (i > size - 1) {
                        i--;
                        j--;
                        direction = POPULATE_NEXT_CELL.GO_LEFT;
                    }
                    break;
                }
                case GO_LEFT: {
                    j--;
                    if (j < 0) {
                        j++;
                        i--;
                        direction = POPULATE_NEXT_CELL.GO_UP;
                    }
                    break;
                }
                case GO_UP:
                    i--;
                    if (i < 0) {
                        i++;
                        j++;
                        direction = POPULATE_NEXT_CELL.GO_RIGHT;
                    } else if (matrix[i][j] != null) {
                        i++;
                        j++;
                        direction = POPULATE_NEXT_CELL.GO_RIGHT;
                    }
                    break;
            }

        }


//        matrix[0][0] = 1;
//        matrix[0][1] = 2;
//        matrix[1][1] = 3;
//        matrix[1][0] = 4;


        return matrix;
    }
}
