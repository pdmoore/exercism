using System;

public static class PigLatin
{
    public static string Translate(string word)
    {
        if (StartsWithVowel(word))
        {
            return word + "ay";
        }

        return "igpay";
    }

    private static bool StartsWithVowel(string word)
    {
        string vowels = "aeiou";
        return vowels.Contains(word.ToCharArray()[0]);
    }
}