import java.awt.*;
import java.awt.geom.Point2D;

public class SpiralMatrixBuilder {

    private static enum POPULATE_NEXT_CELL { GO_RIGHT, GO_DOWN, GO_LEFT, GO_UP };

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
            cellCoordinate = new Point(i, j);
        }

        return matrix;
    }
}
