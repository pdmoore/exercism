using System;

public static class MatchingBrackets
{
    public static bool IsPaired(string input)
    {
        int bracketCount = 0;
        foreach (char c in input)
        {
            if (c.Equals('['))
            {
                bracketCount++;
            } else if (c.Equals(']'))
            {
                bracketCount--;
            }
        }


        return bracketCount == 0;
    }
}
