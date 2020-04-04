using System;

public static class MatchingBrackets
{
    public static bool IsPaired(string input)
    {
        int bracketCount = 0;
        int curlyCount = 0;
        int parenCount = 0;
        foreach (char c in input)
        {
            if (c.Equals('['))
            {
                bracketCount++;
            } else if (c.Equals(']'))
            {
                bracketCount--;
            }
            
            if (c.Equals('{'))
            {
                curlyCount++;
            } else if (c.Equals('}'))
            {
                curlyCount--;
            }

            if (c.Equals('('))
            {
                parenCount++;
            } else if (c.Equals(')'))
            {
                parenCount--;
            }

            if (curlyCount < 0)
            {
                return false;
            }
        }


        return bracketCount == 0 && curlyCount == 0 && parenCount == 0;
    }
}
