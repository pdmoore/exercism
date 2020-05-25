public class SpiralMatrix
{
    private static int _count;
    private static int[,] _matrix;
    private static int limitLeft;
    private static int limitTop;
    private static int limitRight;
    private static int limitBottom;
    
    public static int[,] GetMatrix(int size)
    {
        _matrix = new int[size, size];
        _count = 1;
        
        limitLeft = 0;
        limitTop = 0;
        limitRight = size - 1;
        limitBottom = size - 1;

        while (matrixHasEmptyCells(size))
        {
            fillAcrossToTheRight();
            fillDownRightmostEdgeToBottom();
            fillAcrossBottomToLeftmostEdge();
            FillUpLeftmostEdgeToTop();
        }

        return _matrix;
    }

    private static bool matrixHasEmptyCells(int size) => _count <= size * size;

    private static void FillUpLeftmostEdgeToTop() {
        for (int fillRow = limitBottom; fillRow >= limitTop; fillRow--) {
            _matrix[fillRow, limitLeft] = _count++;
        }

        limitLeft++;
    }

    private static void fillAcrossBottomToLeftmostEdge() {
        for (int fillColumn = limitRight; fillColumn >= limitLeft; fillColumn--) {
            _matrix[limitBottom, fillColumn] = _count++;
        }

        limitBottom--;
    }

    private static void fillDownRightmostEdgeToBottom() {
        for (int fillRow = limitTop; fillRow <= limitBottom; fillRow++) {
            _matrix[fillRow, limitRight] = _count++;
        }

        limitRight--;
    }

    private static void fillAcrossToTheRight() {
        for (int fillColumn = limitLeft; fillColumn <= limitRight; fillColumn++) {
            _matrix[limitTop, fillColumn] = _count++;
        }

        limitTop++;
    }
}