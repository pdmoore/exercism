using System.Collections;
using System.Collections.Generic;
using System.Linq;

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

        foreach (var thisChar in input.Select(c => c.ToString())) {
            if (_pairs.ContainsValue(thisChar))
            {
                _openPairs.Push(thisChar);
            }
            else if (_pairs.ContainsKey(thisChar))
            {
                if (NoMatchingOpener() ||
                    CloserDoesNotMatchOpener(thisChar)) 
                    return false;
            }
        }
        
        return AnyUnmatchedPairs();
    }

    private static bool AnyUnmatchedPairs() => _openPairs.Count == 0;
    
    private static bool NoMatchingOpener() => _openPairs.Count == 0;

    private static bool CloserDoesNotMatchOpener(string key) => !_openPairs.Pop().Equals(_pairs[key.ToString()]);
}
