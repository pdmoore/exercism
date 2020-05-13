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
            count = 1;

            int limitLeft = 0;
            int limitRight = size;
            int limitTop = 0;
            int limitBottom = size;
            

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
            
            //go right again
            //TODO wrap all the above in a loop, and short circuit when count == size*size
            // likely need to do the same check after each for loop
            for (int fillColumn = limitLeft; fillColumn < limitRight; fillColumn++)
            {
                matrix[limitTop, fillColumn] = count++;
            }
        }
        
        return matrix;
    }
}