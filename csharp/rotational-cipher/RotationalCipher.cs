using System;
using System.Linq;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey)
    {
        // TODO - replace foreach with stream/linq
        string result = "";
        foreach (var c in text)
        {
            result += Encode(c, shiftKey);
        }

        return result;
    }

    private static char Encode(char c, int shiftKey)
    {
        if (!char.IsLetter(c))
        {
            return c;
        }

        // TODO - better approach to wrap back past z? 
        var result = (c + shiftKey);
        if (char.IsLower(c) && result > 'z')
        {
            result -= 26;
        } else if (char.IsUpper(c) && result > 'Z')
        {
            result -= 26;
        }

        return (char)result;
    }
}