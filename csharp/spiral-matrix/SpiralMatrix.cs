public class SpiralMatrix
{
    private static int _count;
    private static int[,] _matrix;
    private static int _limitLeft;
    private static int _limitTop;
    private static int _limitRight;
    private static int _limitBottom;

    public static int[,] GetMatrix(int size)
    {
        _matrix = new int[size, size];
        _count = 1;

        _limitLeft = 0;
        _limitTop = 0;
        _limitRight = size - 1;
        _limitBottom = size - 1;

        while (MatrixHasEmptyCells(size))
        {
            FillAcrossTopToTheRightmostEdge();
            _limitTop++;
            
            FillDownRightmostEdgeToBottom();
            _limitRight--;
            
            FillBackAcrossBottomToLeftmostEdge();
            _limitBottom--;
            
            FillUpLeftmostEdgeToTop();
            _limitLeft++;
        }

        return _matrix;
    }

    private static bool MatrixHasEmptyCells(int size) => _count <= size * size;

    private static void FillAcrossTopToTheRightmostEdge()
    {
        for (int fillColumn = _limitLeft; fillColumn <= _limitRight; fillColumn++)
        {
            _matrix[_limitTop, fillColumn] = _count++;
        }
    }

    private static void FillDownRightmostEdgeToBottom()
    {
        for (int fillRow = _limitTop; fillRow <= _limitBottom; fillRow++)
        {
            _matrix[fillRow, _limitRight] = _count++;
        }
    }

    private static void FillBackAcrossBottomToLeftmostEdge()
    {
        for (int fillColumn = _limitRight; fillColumn >= _limitLeft; fillColumn--)
        {
            _matrix[_limitBottom, fillColumn] = _count++;
        }
    }

    private static void FillUpLeftmostEdgeToTop()
    {
        for (int fillRow = _limitBottom; fillRow >= _limitTop; fillRow--)
        {
            _matrix[fillRow, _limitLeft] = _count++;
        }
    }
}