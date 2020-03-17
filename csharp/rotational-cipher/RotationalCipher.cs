using System;
using System.Linq;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey)
    {
        if (shiftKey == 0)
        {
            return text;
        }


        string result = "";
        foreach (var c in text) {
            result += encode(c, shiftKey);
        }

        return result;
    }

    private static string encode(char c, int shiftKey) => Char.ToString((char) (c + shiftKey));
}