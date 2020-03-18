using System;
using System.Linq;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey)
    {
        // TODO - replace foreach with stream/linq
        string result = "";
        foreach (var c in text) {
            if (char.IsLetter(c))
            {
            result += Encode(c, shiftKey);
                
            }
            else
            {
                result += c;
            }
        }

        return result;
    }

    private static string Encode(char c, int shiftKey)
    {
        // TODO - better approach to wrap back past z? 
        var result = (c + shiftKey);
        if (result > 'z')
        {
            result -= 26;
        }
        return char.ToString((char)result);
    }
}