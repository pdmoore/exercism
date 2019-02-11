import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new TreeSet<>();

        for (int i = 0; i < numberOfRows(); i++) {
            int largestInRow = Collections.max(values.get(i));

            for (int j = 0; j < numberOfColumns(); j++) {
                int smallestInColumn = smallestOfColumn(j);

                int currentCellValue = values.get(i).get(j);
                if (currentCellValue == largestInRow && currentCellValue == smallestInColumn) {
                    saddlePoints.add(new MatrixCoordinate(i, j));
                }
            }
        }

        return saddlePoints;
    }

    private int numberOfColumns() {
        return values.get(0).size();
    }

    private int numberOfRows() {
        return values.size();
    }

    private int smallestOfColumn(int columnIndex) {
        int smallestOfColumn = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfColumns(); i++) {
            int currentColumnValue = values.get(i).get(columnIndex);
            if (currentColumnValue < smallestOfColumn) {
                smallestOfColumn = currentColumnValue;
            }
        }

        return smallestOfColumn;
    }
}
