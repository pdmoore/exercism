using System.Collections;
using System.Collections.Generic;

public static class MatchingBrackets
{
    private static readonly Dictionary<string, string> _pairs = new Dictionary<string, string>();

    static MatchingBrackets() {
        _pairs.Add(")", "(");
        _pairs.Add("]", "[");
        _pairs.Add("}", "{");
    }

    public static bool IsPaired(string input)
    {
        Stack openPair = new Stack();

        foreach (char c in input)
        {
            if (_pairs.ContainsValue(c.ToString()))
            {
                openPair.Push(c.ToString());
            }
            else if (_pairs.ContainsKey(c.ToString()))
            {
                if (openPair.Count == 0)
                    return false;

                string key = c.ToString();
                string value = _pairs[key];

                if (!openPair.Pop().Equals(value)) return false;
            }
        }
        return openPair.Count == 0;
    }
}
