﻿using System;
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
        int row = 0;
        for (int col = 0; col < size; col++)
        {
            matrix[row, col] = count++;
        }
        
        if (size == 2)
        {
            // fill in last row from right to left
            row++;
            for (int i = size - 1; i >= 0; i--)
            {
                matrix[row, i] = count++;
            }
        }
        else if (size == 3)
        {
            for (int i = 1; i < size; i++)
            {
                matrix[i, 2] = count++;
            }
            
            
            matrix[2, 1] = 6;
            matrix[2, 0] = 7;
            
            matrix[1, 0] = 8;
            matrix[1, 1] = 9;
        }
        
        return matrix;
    }
}