using System;
using System.Collections.Generic;
using System.Linq;

public static class ProteinTranslation
{
    public static string[] Proteins(string strand)
    {
        if (strand.Length == 0)
        {
            return Array.Empty<string>();
        }
        
        List<string> result = new List<string>();

        string thisCodon = strand.Substring(0, 3);

        List<string> pCodons = new List<string>(){ "UUU", "UUC" };
        List<string> mCodons = new List<string>(){ "AUG" };
        List<string> lCodons = new List<string>(){ "UUA", "UUG" };
        List<string> sCodons = new List<string>(){ "UCA", "UCC", "UCU" };
        
        if (pCodons.Contains(thisCodon))
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

        return result.ToArray();
    }
}