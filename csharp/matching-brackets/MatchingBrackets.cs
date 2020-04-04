using System;
using System.Collections;

public static class MatchingBrackets
{
    public static bool IsPaired(string input)
    {
        Stack openPair = new Stack();
        string openers = "([{";
        
        foreach (char c in input)
        {
            if (openers.Contains(c))
            {
                openPair.Push(c);
            }
            
            switch (c) {
                case ')' when openPair.Pop() != "(":
                    return false;
            }
        }

        return openPair.Count == 0;
    }
}
