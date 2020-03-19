using System;
using System.Linq;

public static class RotationalCipher
{
    private static readonly int NumCharactersInAlphabet = 26;
    
    public static string Rotate(string text, int shiftKey) => text.Aggregate("", (result, c) => result + Encode(c, shiftKey));

    private static char Encode(char c, int shiftKey)
    {
        if (!char.IsLetter(c))
        {
            return c;
        }

        return Rotate(c, shiftKey);
    }

    private static char Rotate(char c, int shiftKey) {
        var rotatedChar = (c + shiftKey);

        if ((char.IsLower(c) && rotatedChar > 'z') ||
            (char.IsUpper(c) && rotatedChar > 'Z')) {
            rotatedChar -= NumCharactersInAlphabet;
        }

        return (char) rotatedChar;
    }
}