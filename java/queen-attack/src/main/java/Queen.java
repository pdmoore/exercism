public class Queen {
    final int row;
    final int column;

    public Queen(int row, int column) {
        validateParameters(row, column);

        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;

        Queen other = (Queen) obj;
        return (this.row == other.row &&
                this.column == other.column);
    }

    public boolean canAttack(int row, int column) {
        return (this.row    == row    ||
                this.column == column ||
                areDiagonal(row, column));
    }

    private boolean areDiagonal(int row, int column) {
        return Math.abs(this.row - row) == Math.abs(this.column - column);
    }

    private void validateParameters(int row, int column) {
        if (row < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        } else if (row > 7) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }

        if (column < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        } else if (column > 7) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
