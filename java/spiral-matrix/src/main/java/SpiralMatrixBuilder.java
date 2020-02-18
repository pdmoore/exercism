import java.awt.*;
import java.awt.geom.Point2D;

public class SpiralMatrixBuilder {

    private static enum POPULATE_NEXT_CELL {GO_RIGHT, GO_DOWN, GO_LEFT, GO_UP}

    ;

    public Integer[][] buildMatrixOfSize(int size) {
        Integer[][] matrix;
        matrix = new Integer[size][size];
        POPULATE_NEXT_CELL direction = POPULATE_NEXT_CELL.GO_RIGHT;
        Point cellCoordinate = new Point(0, 0);

        // TODO - refactor
        // check if index can be incremented instead of incr/check/decr
        // bust case code into helper methods?
        int i = 0;
        int j = 0;
        int counter = 1;
        while (counter <= (size * size)) {
            matrix[cellCoordinate.x][cellCoordinate.y] = counter++;

            switch (direction) {
                case GO_RIGHT: {
                    if (((j + 1) <= size - 1) && matrix[i][j + 1] == null) {
                        j++;
                    } else {
                        i++;
                        direction = POPULATE_NEXT_CELL.GO_DOWN;
                    }

                    cellCoordinate = new Point(i, j);
                    break;
                }
                case GO_DOWN: {
                    if (i + 1 <= size - 1 && matrix[i+1][j] == null) {
                        i++;
                    } else {
                        j--;
                        direction = POPULATE_NEXT_CELL.GO_LEFT;
                    }

                    cellCoordinate = new Point(i, j);
                    break;
                }
                case GO_LEFT: {
                    if (j - 1 >= 0 && matrix[i][j - 1] == null) {
                        j--;
                    } else {
                        i--;
                        direction = POPULATE_NEXT_CELL.GO_UP;
                    }
                    cellCoordinate = new Point(i, j);
                    break;
                }
                case GO_UP:
                    if ((i - 1 >= 0) && (matrix[i - 1][j] == null)) {
                        i--;
                    } else {
                        j++;
                        direction = POPULATE_NEXT_CELL.GO_RIGHT;
                    }
                    cellCoordinate = new Point(i, j);
                    break;
            }
        }

        return matrix;
    }
}
