using System;
using System.Linq;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey)
    {
        string result = "";
        foreach (var c in text) {
            result += encode(c, shiftKey);
        }

        return result;
    }

    private static string encode(char c, int shiftKey)
    {
        var shiftAmount = shiftKey % 26;
        var result = (c + shiftAmount);
        if (result > 'z')
        {
            result -= 26;
        }
        return Char.ToString((char)result);
    }
}