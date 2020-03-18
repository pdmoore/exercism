using System;
using System.Linq;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey) => text.Aggregate("", (result, c) => result + Encode(c, shiftKey));

    private static char Encode(char c, int shiftKey)
    {
        if (!char.IsLetter(c))
        {
            return c;
        }

        // TODO - better approach to wrap back past z? 
        var result = (c + shiftKey);
        if ((char.IsLower(c) && result > 'z') ||
            (char.IsUpper(c) && result > 'Z'))
        {
            result -= 26;
        }

        return (char)result;
    }
}