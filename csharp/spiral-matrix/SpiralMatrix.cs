public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        int[,] matrix = new int[size, size];

        int count = 1;
        int limitLeft = 0;
        int limitRight = size;
        int limitTop = 0;
        int limitBottom = size;

        while (count <= size * size)
        {
            // fill across right
            for (int fillColumn = limitLeft; fillColumn < limitRight; fillColumn++)
            {
                matrix[limitTop, fillColumn] = count++;
            }
            limitTop++;

            // fill down rightmost unfilled edge
            for (int fillRow = limitTop; fillRow < limitBottom; fillRow++)
            {
                matrix[fillRow, limitRight - 1] = count++;
            }
            limitRight--;

            // fill across bottom
            for (int fillColumn = limitRight - 1; fillColumn >= limitLeft; fillColumn--)
            {
                matrix[limitBottom - 1, fillColumn] = count++;
            }
            limitBottom--;
            
            // fill up leftmost unfilled edge
            for (int fillRow = limitBottom - 1; fillRow >= limitTop; fillRow--)
            {
                matrix[fillRow, limitLeft] = count++;
            }
            limitLeft++;
        }

        return matrix;
    }
}