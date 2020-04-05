using System.Collections;
using System.Collections.Generic;

public static class MatchingBrackets
{
    private static readonly Dictionary<string, string> _pairs = new Dictionary<string, string>();
    private static Stack _openPairs;

    static MatchingBrackets() {
        _pairs.Add(")", "(");
        _pairs.Add("]", "[");
        _pairs.Add("}", "{");
    }

    public static bool IsPaired(string input)
    {
        _openPairs = new Stack();

        foreach (char c in input)
        {
            if (_pairs.ContainsValue(c.ToString()))
            {
                _openPairs.Push(c.ToString());
            }
            else if (_pairs.ContainsKey(c.ToString()))
            {
                if (NoMatchingOpener() ||
                    CloserDoesNotMatchOpener(c)) 
                    return false;
            }
        }
        
        return AnyUnmatchedPairs();
    }

    private static bool AnyUnmatchedPairs() => _openPairs.Count == 0;
    
    private static bool NoMatchingOpener() => _openPairs.Count == 0;

    private static bool CloserDoesNotMatchOpener(char key) => !_openPairs.Pop().Equals(_pairs[key.ToString()]);
}
