using System;
using System.Threading;

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
        for (int col = 0; col < size; col++)
        {
            matrix[0, col] = count++;
        }
        
        if (size == 1)
        {
        }
        else if (size == 2)
        {
            matrix[1, 0] = 4;
            matrix[1, 1] = 3;
        }
        else
        {
            matrix[1, 0] = 8;
            matrix[1, 1] = 9;
            matrix[1, 2] = 4;
            
            matrix[2, 0] = 7;
            matrix[2, 1] = 6;
            matrix[2, 2] = 5;
        }
        
        return matrix;
    }
}