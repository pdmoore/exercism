using System;

public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        if (size == 0)
        {
            return new int[size, size];
        }

        var matrix = new[,]
        {
            {1}
        };

        return matrix;
    }
}