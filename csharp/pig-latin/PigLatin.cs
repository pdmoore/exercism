using System;

public static class PigLatin
{
    private static readonly string Vowels = "aeiou";
    
    public static string Translate(string word)
    {
        if (StartsWithVowel(word))
        {
            return word + "ay";
        }

        return "igpay";
    }

    private static bool StartsWithVowel(string word) => Vowels.Contains(word.ToCharArray()[0]);
}