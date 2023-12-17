class Queen {

    int row;
    int column;
    Queen(int row, int column) {
        if (row < 0 || column < 0) {
            throw new Exception("position must be positive");
        }
        if (row >= 8 || column >= 8) {
            throw new Exception("poisiton must be on board [0..8]");
        }
        this.row = row;
        this.column = column;
    }
}
