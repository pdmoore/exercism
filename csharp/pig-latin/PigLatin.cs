using System;

public static class PigLatin
{
    private const string Vowels = "aeiou";

    public static string Translate(string word)
    {
        if (StartsWithVowel(word))
        {
            return word + "ay";
        }

        var firstChar = word.ToCharArray()[0];
        var restOfWord = word.Substring(1);

        return restOfWord + firstChar + "ay";
    }

    private static bool StartsWithVowel(string word) => Vowels.Contains(word.ToCharArray()[0]);
}