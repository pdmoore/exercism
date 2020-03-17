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


        String result = "";
        foreach (char c in text)
        {
            result += Char.ToString((char) (c + 1));
        }
        return result;
    }
}