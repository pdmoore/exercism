using System;
using System.Linq;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey)
    {
        string result = "";
        foreach (var c in text) {
            result += Encode(c, shiftKey);
        }

        return result;
    }

    private static string Encode(char c, int shiftKey)
    {
        var result = (c + shiftKey);
        if (result > 'z')
        {
            result -= 26;
        }
        return char.ToString((char)result);
    }
}