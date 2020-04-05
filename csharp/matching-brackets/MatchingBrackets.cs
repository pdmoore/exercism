using System;
using System.Collections;

public static class MatchingBrackets
{
    public static bool IsPaired(string input)
    {
        //TODO - confirm last couple of tests pass
        //TODO - key/value mapping opener to closer?
        
        Stack openPair = new Stack();
        string openers = "([{";
        string closers = ")]}";

        foreach (char c in input)
        {
            if (openers.Contains(c))
            {
                openPair.Push(c);
            }
            else if (closers.Contains(c))
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
