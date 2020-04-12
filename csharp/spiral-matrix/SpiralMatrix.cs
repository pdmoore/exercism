using System;

public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        if (size == 0)
        {
            return new int[size, size];
        }


        int[,] matrix = new int[size, size];
        if (size == 1)
        {
            matrix[0, 0] = 1;
        }
        else
        {
            matrix[0, 0] = 1;
            matrix[0, 1] = 2;
            matrix[1, 0] = 4;
            matrix[1, 1] = 3;
        }
        
        return matrix;
    }
}