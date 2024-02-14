using System;
using System.Collections.Generic;
using System.Linq;


public static class ProteinTranslation
{
    static List<string> tryptophan = new List<string>() { "UGG" };
    static List<string> cCodons = new List<string>() { "UGC", "UGU" };
    static List<string> pCodons = new List<string>() { "UUU", "UUC" };
    static List<string> mCodons = new List<string>() { "AUG" };
    static List<string> lCodons = new List<string>() { "UUA", "UUG" };
    static List<string> sCodons = new List<string>() { "UCA", "UCC", "UCG", "UCU" };
    static List<string> tCodons = new List<string>() { "UAC", "UAU" };
    private static List<string> stopCodons = new List<string>() { "UAA", "UAG", "UGA" };

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

            if (stopCodons.Contains(thisCodon))
            {
                break;
            } else if (pCodons.Contains(thisCodon))
            {
                result.Add("Phenylalanine");
            }
            else if (mCodons.Contains(thisCodon))
            {
                result.Add("Methionine");
            }
            else if (lCodons.Contains(thisCodon))
            {
                result.Add("Leucine");
            }
            else if (sCodons.Contains(thisCodon))
            {
                result.Add("Serine");
            }
            else if (tCodons.Contains(thisCodon))
            {
                result.Add("Tyrosine");
            }
            else if (cCodons.Contains(thisCodon))
            {
                result.Add("Cysteine");
            }
            else if (tryptophan.Contains(thisCodon))
            {
                result.Add("Tryptophan");
            }
        }

        return result.ToArray();
    }
}