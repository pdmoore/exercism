using System.Collections;
using System.Collections.Generic;
using System.Linq;

public static class MatchingBrackets
{
    private static readonly Dictionary<char, char> _pairs = new Dictionary<char, char>();
    private static Stack _openPairs;

    static MatchingBrackets() {
        _pairs.Add(')', '(');
        _pairs.Add(']', '[');
        _pairs.Add('}', '{');
    }

    public static bool IsPaired(string input)
    {
        _openPairs = new Stack();

        foreach (var thisChar in input.Select(c => c)) {
            if (IsOpener(thisChar))
            {
                _openPairs.Push(thisChar);
            }
            else if (IsCloser(thisChar))
            {
                if (!CloserMatchesOpener(thisChar))
                    return false;
            }
        }
        
        return AnyUnmatchedPairs();
    }

    private static bool IsCloser(char key) => _pairs.ContainsKey(key);

    private static bool IsOpener(char value) => _pairs.ContainsValue(value);

    private static bool CloserMatchesOpener(in char key) =>
        _openPairs.Count > 0 &&
        _openPairs.Pop().Equals(_pairs[key]);

    private static bool AnyUnmatchedPairs() => _openPairs.Count == 0;
}
