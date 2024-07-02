using System;
using System.Linq;

public static class PigLatin
{
    private const string Vowels = "aeiou";

    public static string Translate(string word)
    {
        if (StartsWith(word, "xr") || StartsWith(word, "yt"))
        {
            return word + "ay";
        }
        
        if (StartsWithVowel(word))
        {
            return word + "ay";
        }

        if (StartsWithQ(word) && SecondLetterIsU(word))
        {
            return word[2..] + "qu" + "ay";
        }

        if (word.Contains("qu"))
        {
            var charAfterU = FirstVowelIndexOf(word, Vowels) + 1;
            var lettersUpToQu = word.Substring(0, charAfterU);
            var lettersAfterU = word.Substring(charAfterU);
            return lettersAfterU + lettersUpToQu + "ay";
        }
        
        if (word.StartsWith("y"))
        {
            var firstVowelIndex = FirstVowelIndexOf(word, Vowels);
            var initialConsonants = word.Substring(0, firstVowelIndex);
            var restOfWord = word.Substring(firstVowelIndex);

            return restOfWord + initialConsonants + "ay";
        }
        
        // rule is grab the first n characters up to the first vowel
        var firstVowelOrY = FirstVowelIndexOf(word, Vowels + "y");
        var startOfWord = word.Substring(0, firstVowelOrY);
        var remainder = word.Substring(firstVowelOrY);

        return remainder + startOfWord + "ay";
    }

    private static bool StartsWith(string word, string startingChars) => 
        word[..2].Equals(startingChars);

    private static bool SecondLetterIsU(string word) => 
        word.ToCharArray()[1] == 'u';

    private static bool StartsWithQ(string word) => 
        word.ToCharArray()[0] == 'q';

    private static int FirstVowelIndexOf(string word, string lookingFor)
    {
        var i = 0;
        var charArray = word.ToCharArray();
        while (i <= word.Length && !lookingFor.Contains(charArray[i]))
        {
            i++;
        }
        return i;
    }

    private static bool StartsWithVowel(string word) => Vowels.Contains(word.ToCharArray()[0]);
}