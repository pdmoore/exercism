
class Matrix {

    int[][] matrix;
    

    Matrix(String matrixAsString) {
        String[] rowsAsString = matrixAsString.split("\\n");

        int numRows = rowsAsString.length;
        int numColumns = rowsAsString[0].split(" ").length;

        matrix = new int[numRows][numColumns];

        for (int i = 0; i < rowsAsString.length; i++) {
            String[] numbersInRow = rowsAsString[i].split(" ");
            for (int j = 0; j < numbersInRow.length; j++) {
                matrix[i][j] = Integer.parseInt(numbersInRow[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[getRowsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            column[i] = matrix[i][columnNumber];
        }

        return column;
    }

    int getRowsCount() {
        return matrix.length;
    }

    int getColumnsCount() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
