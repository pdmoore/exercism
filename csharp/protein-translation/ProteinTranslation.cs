using System;
using System.Collections.Generic;
using System.Linq;


public static class ProteinTranslation
{
    private static readonly List<string> Tryptophan = new List<string>() { "UGG" };
    private static readonly List<string> Cysteine = new List<string>() { "UGC", "UGU" };
    private static readonly List<string> Phenylalanine = new List<string>() { "UUU", "UUC" };
    private static readonly List<string> Methionine = new List<string>() { "AUG" };
    private static readonly List<string> Leucine = new List<string>() { "UUA", "UUG" };
    private static readonly List<string> Serine = new List<string>() { "UCA", "UCC", "UCG", "UCU" };
    private static readonly List<string> Tyrosine = new List<string>() { "UAC", "UAU" };
    private static readonly List<string> StopCodons = new List<string>() { "UAA", "UAG", "UGA" };

    public static string[] Proteins(string strand)
    {
        if (strand.Length == 0)
        {
            return Array.Empty<string>();
        }

        List<string> result = new List<string>();
        foreach (var thisCodon in Enumerable.Range(0, strand.Length / 3)
                     .Select(i => strand.Substring(i * 3, 3)))
        {
            if (StopCodons.Contains(thisCodon))
            {
                break;
            } else if (Phenylalanine.Contains(thisCodon))
            {
                result.Add("Phenylalanine");
            }
            else if (Methionine.Contains(thisCodon))
            {
                result.Add("Methionine");
            }
            else if (Leucine.Contains(thisCodon))
            {
                result.Add("Leucine");
            }
            else if (Serine.Contains(thisCodon))
            {
                result.Add("Serine");
            }
            else if (Tyrosine.Contains(thisCodon))
            {
                result.Add("Tyrosine");
            }
            else if (Cysteine.Contains(thisCodon))
            {
                result.Add("Cysteine");
            }
            else if (Tryptophan.Contains(thisCodon))
            {
                result.Add("Tryptophan");
            }
        }

        return result.ToArray();
    }
}