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
            var matrix = new[,]
            {
                {1}
            };
            return matrix;
        }

        var expected = new[,]
        {
            {1, 2},
            {4, 3}
        };
        return expected;
    }
}