using System.Collections;
using System.Collections.Generic;

public static class MatchingBrackets
{
    private static readonly Dictionary<string, string> _pairs = new Dictionary<string, string>();

    static MatchingBrackets() {
        _pairs.Add("(", ")");
        _pairs.Add("[", "]");
        _pairs.Add("{", "}");
    }

    public static bool IsPaired(string input)
    {
        Stack openPair = new Stack();

        foreach (char c in input)
        {
            if (_pairs.ContainsKey(c.ToString()))
            {
                openPair.Push(c);
            }
            else if (_pairs.ContainsValue(c.ToString()))
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
