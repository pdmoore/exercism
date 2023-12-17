class QueenAttack {

    static canAttack(Queen q1, Queen q2) {
        def onSameRow = q1.row == q2.row
        def onSameColumn = q1.column == q2.column
        boolean onDiagonal = Math.abs(q1.row - q2.row) == Math.abs(q1.column - q2.column);
        return onSameRow ||onSameColumn || onDiagonal;
    }
}
