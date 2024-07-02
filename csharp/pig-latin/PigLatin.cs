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

        if (StartsWithQ(word) && SecondLetterIsU(word))
        {
            return word[2..] + "qu" + "ay";
        }
        
        // rule is grab the first n characters up to the first vowel
        var firstVowelIndex = FirstVowelIndexOf(word);
        var initialConsonants = word.Substring(0, firstVowelIndex);
        var restOfWord = word.Substring(firstVowelIndex);

        return restOfWord + initialConsonants + "ay";
    }

    private static bool SecondLetterIsU(string word) => word.ToCharArray()[1] == 'u';

    private static bool StartsWithQ(string word) => word.ToCharArray()[0] == 'q';

    private static int FirstVowelIndexOf(string word)
    {
        var i = 0;
        var charArray = word.ToCharArray();
        while (i <= word.Length && !Vowels.Contains(charArray[i]))
        {
            i++;
        }
        return i;
    }

    private static bool StartsWithVowel(string word) => Vowels.Contains(word.ToCharArray()[0]);
}