using System;
using System.Collections.Generic;

public static class ProteinTranslation
{
    public static string[] Proteins(string strand)
    {
        List<string> result = new List<string>();

        if (strand.Contains("UUU") || strand.Contains("UUC"))
        {
            result.Add("Phenylalanine");
        }
        else if (strand.Contains("AUG"))
        {
            result.Add("Methionine");
        }
        else if (strand.Contains("UUA") || strand.Contains("UUG"))
        {
            result.Add("Leucine");
        }
        else if (strand.Contains("UCU") || strand.Contains("UCC") || strand.Contains("UCA") || strand.Contains("UCG"))
        {
            result.Add("Serine");
        }

        return result.ToArray();
    }
}