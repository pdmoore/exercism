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
        Stack openPairs = new Stack();

        foreach (char c in input)
        {
            if (_pairs.ContainsValue(c.ToString()))
            {
                openPairs.Push(c.ToString());
            }
            else if (_pairs.ContainsKey(c.ToString()))
            {
                if (NoMatchingOpener(openPairs) ||
                    CloserDoesNotMatchOpener(openPairs, c)) 
                    return false;
            }
        }
        
        return AnyUnmatchedPairs(openPairs);
    }

    private static bool AnyUnmatchedPairs(Stack openPair) => openPair.Count == 0;

    private static bool CloserDoesNotMatchOpener(Stack openPair, char key) => !openPair.Pop().Equals(_pairs[key.ToString()]);

    private static bool NoMatchingOpener(Stack openPair) => openPair.Count == 0;
}
