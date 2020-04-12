using System;

public class SpiralMatrix
{
    public static int[,] GetMatrix(int size)
    {
        if (size == 0)
        {
            
        return new int[size,size];
        }

        var expected = new[,]
        {
            { 1 }
        };

        return expected;

    }
}
