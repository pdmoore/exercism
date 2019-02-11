
class Matrix {

    private int[][] integerMatrix;

    Matrix(String matrixAsString) {
        String[][] internalMatrix;
        String[] rowsAsStrings = matrixAsString.split("\\r?\\n");
        int numberOfRows = rowsAsStrings.length;
        int numberOfColumns = rowsAsStrings[0].split(" ").length;
        internalMatrix = new String[numberOfRows][numberOfColumns];
        this.integerMatrix = new int[numberOfRows][numberOfColumns];
        for(int i=0; i<rowsAsStrings.length; i++){
            internalMatrix[i] = rowsAsStrings[i].split(" ");
        }
        for(int i=0; i<numberOfRows; i++){
            for(int j=0; j<numberOfColumns; j++){
                this.integerMatrix[i][j] = Integer.parseInt(internalMatrix[i][j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return this.integerMatrix[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        int[] result = new int[this.integerMatrix.length];
        for(int i=0; i<result.length; i++){
            result[i] = this.integerMatrix[i][columnNumber];
        }
        return result;
    }


//    int[][] matrix;
//
//    Matrix(String matrixAsString) {
//        String[] rowsAsString = matrixAsString.split("\\n");
//
//        int numRows = rowsAsString.length;
//        int numColumns = rowsAsString[0].split(" ").length;
//
//        matrix = new int[numRows][numColumns];
//
//        for (int i = 0; i < rowsAsString.length; i++) {
//            String[] numbersInRow = rowsAsString[i].split(" ");
//            for (int j = 0; j < numbersInRow.length; j++) {
//                matrix[i][j] = Integer.parseInt(numbersInRow[j]);
//            }
//        }
//    }
//
//    int[] getRow(int rowNumber) {
//        return matrix[rowNumber];
//    }
//
//    int[] getColumn(int columnNumber) {
//        int[] column = new int[getRowsCount()];
//
//        for (int i = 0; i < getRowsCount(); i++) {
//            column[i] = matrix[i][columnNumber];
//        }
//
//        return column;
//    }
//
//    int getRowsCount() {
//        return matrix.length;
//    }
//
//    int getColumnsCount() {
//        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
//    }
}
