using System.Collections;
using System.Collections.Generic;

public static class MatchingBrackets
{
    public static bool IsPaired(string input)
    {
        //TODO - key/value mapping opener to closer?
        
        Stack openPair = new Stack();
        Dictionary<string, string> pairs = new Dictionary<string, string>();
        pairs.Add("(", ")");
        pairs.Add("[", "]");
        pairs.Add("{", "}");

        foreach (char c in input)
        {
            if (pairs.ContainsKey(c.ToString()))
            {
                openPair.Push(c);
            }
            else if (pairs.ContainsValue(c.ToString()))
            {
                if (openPair.Count == 0)
                    return false;

                switch (c)
                {
                    case ')' when !openPair.Pop().Equals('('):
                    case ']' when !openPair.Pop().Equals('['):
                    case '}' when !openPair.Pop().Equals('{'):
                        return false;
                }
            }
        }
        return openPair.Count == 0;
    }
}
