using System;

public static class PigLatin
{
    public static string Translate(string word)
    {
        return word + word.ToCharArray()[0] + "y";
    }
}