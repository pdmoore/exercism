public class QueenAttackCalculator {

    private final Queen q1;
    private final Queen q2;

    public QueenAttackCalculator(Queen q1, Queen q2) {
        validateParameters(q1, q2);

        this.q1 = q1;
        this.q2 = q2;
    }

//    public boolean canQueensAttackOneAnother() {
//        return q1.canAttack(q2.row, q2.column);
//    }


    public boolean canQueensAttackOneAnother() {
        if(q1.getRow() == q2.getRow() ||
                q1.getColumn() == q2.getColumn()) {
            return true;
        }

        return testDiagonals();
    }

    private boolean testDiagonals() {
        boolean isBlackQueensRowLarger = q1.getRow() > q2.getRow();
        boolean isBlackQueensColumnLarger = q1.getColumn() > q2.getColumn();

        int rowIncrement = isBlackQueensRowLarger ? 1 : -1;
        int columnIncrement = isBlackQueensColumnLarger ? 1 : -1;
        int row = q2.getRow() + rowIncrement;
        int column = q2.getColumn() + columnIncrement;

        while(row >= 0 && row <= 7 && column >= 0 && column <= 7) {
            if(row == q1.getRow() && column == q1.getColumn()) {
                return true;
            }

            row += rowIncrement;
            column += columnIncrement;
        }

        return false;
    }


    private void validateParameters(Queen q1, Queen q2) {
        if (null == q1) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }

        if (q1.equals(q2)) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
    }
}
