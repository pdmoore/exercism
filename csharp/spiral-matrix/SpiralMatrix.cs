public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        if (size == 0)
        {
            return new int[size, size];
        }
        
        int[,] matrix = new int[size, size];

        int count = 1;
        int limitLeft = 0;
        int limitRight = size;
        int limitTop = 0;
        int limitBottom = size;

        while (count <= size * size)
        {
            // go right
            for (int fillColumn = limitLeft; fillColumn < limitRight; fillColumn++)
            {
                matrix[limitTop, fillColumn] = count++;
            }

            limitTop++;

            // go down
            for (int fillRow = limitTop; fillRow < limitBottom; fillRow++)
            {
                matrix[fillRow, limitRight - 1] = count++;
            }

            limitRight--;

            // go left
            for (int fillColumn = limitRight - 1; fillColumn >= limitLeft; fillColumn--)
            {
                matrix[limitBottom - 1, fillColumn] = count++;
            }

            limitBottom--;
            // go up
            for (int fillRow = limitBottom - 1; fillRow >= limitTop; fillRow--)
            {
                matrix[fillRow, limitLeft] = count++;
            }

            limitLeft++;
        }

        return matrix;
    }
}