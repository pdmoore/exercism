public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        int[,] matrix = new int[size, size];

        int count = 1;
        int limitLeft = 0;
        int limitRight = size - 1;
        int limitTop = 0;
        int limitBottom = size - 1;

        while (count <= size * size)
        {
            // fill across right
            for (int fillColumn = limitLeft; fillColumn <= limitRight; fillColumn++)
            {
                matrix[limitTop, fillColumn] = count++;
            }
            limitTop++;

            // fill down rightmost unfilled edge
            for (int fillRow = limitTop; fillRow <= limitBottom; fillRow++)
            {
                matrix[fillRow, limitRight] = count++;
            }
            limitRight--;

            // fill across bottom
            for (int fillColumn = limitRight; fillColumn >= limitLeft; fillColumn--)
            {
                matrix[limitBottom, fillColumn] = count++;
            }
            limitBottom--;
            
            // fill up leftmost unfilled edge
            for (int fillRow = limitBottom; fillRow >= limitTop; fillRow--)
            {
                matrix[fillRow, limitLeft] = count++;
            }
            limitLeft++;
        }

        return matrix;
    }
}