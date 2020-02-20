import java.awt.*;

public class SpiralMatrixBuilder {

    private enum POPULATE_NEXT_CELL { GO_RIGHT, GO_DOWN, GO_LEFT, GO_UP }

    public Integer[][] buildMatrixOfSize(int size) {
        Integer[][] matrix = new Integer[size][size];
        Point cellCoordinate = new Point(0, 0);
        POPULATE_NEXT_CELL direction = POPULATE_NEXT_CELL.GO_RIGHT;

        int counter = 1;
        while (counter <= (size * size)) {
            matrix[cellCoordinate.x][cellCoordinate.y] = counter++;

            if (!keepGoing(direction, cellCoordinate, matrix, size)) {
                direction = changeDirection(direction);
            }

            moveOneCell(direction, cellCoordinate);
        }

        return matrix;
    }

    private void moveOneCell(POPULATE_NEXT_CELL direction, Point cellCoordinate) {
        switch (direction) {
            case GO_RIGHT:
                ++cellCoordinate.y;
                break;
            case GO_DOWN:
                ++cellCoordinate.x;
                break;
            case GO_LEFT:
                --cellCoordinate.y;
                break;
            case GO_UP:
                --cellCoordinate.x;
                break;
        }

    }

    private POPULATE_NEXT_CELL changeDirection(POPULATE_NEXT_CELL direction) {
        switch (direction) {
            case GO_RIGHT:
                return POPULATE_NEXT_CELL.GO_DOWN;
            case GO_DOWN:
                return POPULATE_NEXT_CELL.GO_LEFT;
            case GO_LEFT:
                return POPULATE_NEXT_CELL.GO_UP;
            case GO_UP:
                return POPULATE_NEXT_CELL.GO_RIGHT;
        }
        return null;
    }

    private boolean keepGoing(POPULATE_NEXT_CELL direction, Point cellCoordinate, Integer[][] matrix, int size) {
        int x = cellCoordinate.x;
        int y = cellCoordinate.y;

        if (direction == POPULATE_NEXT_CELL.GO_RIGHT) {
            return (((y + 1) <= size - 1) && matrix[x][y + 1] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_DOWN) {
            return (x + 1 <= size - 1 && matrix[x + 1][y] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_LEFT) {
            return (y - 1 >= 0 && matrix[x][y - 1] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_UP) {
            return ((x - 1 >= 0) && (matrix[x - 1][y] == null));
        }

        return false;
    }
}
