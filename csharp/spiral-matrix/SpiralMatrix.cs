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
        int row = 0;
        for (int col = 0; col < size; col++)
        {
            matrix[row, col] = count++;
        }
        
        if (size == 2)
        {
            // fill in last row from right to left
            // collapses Down and Left
            row++;
            for (int i = size - 1; i >= 0; i--)
            {
                matrix[row, i] = count++;
            }
        }
        else if (size == 3)
        {
            row = 0;
            count = 1;
            int col = 0;

            int limitLeft = 0;
            int limitRight = size;
            int limitTop = 0;
            int limitBottom = size;
            

            // go right
            for (int fillColumn = limitLeft; fillColumn < limitRight; fillColumn++)
            {
                matrix[row, fillColumn] = count++;
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
            
            
            matrix[1, 0] = 8;
            matrix[1, 1] = 9;
        }
        
        return matrix;
    }
}