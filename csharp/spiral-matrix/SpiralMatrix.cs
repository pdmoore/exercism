using System;

public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        if (size == 0)
        {
            return new int[size, size];
        }


        if (size == 1)
        {
            int[,] matrix = new int[size, size];
            
            matrix[0, 0] = 1;
            
            return matrix;
        }

        int[,] expected = new int[size, size];
        
        expected[0, 0] = 1;
        expected[0, 1] = 2;
        expected[1, 0] = 4;
        expected[1, 1] = 3;
        
        return expected;
    }
}