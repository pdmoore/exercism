class Queen {

    int row;
    int column;
    Queen(int row, int column) {
        if (row < 0 || column < 0) {
            throw new Exception("position must be positive");
        }
        this.row = row;
        this.column = column;
    }
}
