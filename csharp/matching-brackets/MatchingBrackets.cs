using System;
using System.Collections;

public static class MatchingBrackets
{
    public static bool IsPaired(string input)
    {
        // TODO - switch to stack - push on any open character, pop on any close, closed item must match what is popped
        // after exhausting string chars, return stack isEmpty
        //TODO duplication
        // TODO next test will require checking that open/close pair match before any other character detected
        // maybe it's state based? initial -> any open -> [any open | specific close] -> all close
        Stack openPair = new Stack();
        String openers = "([{";
        
        foreach (char c in input)
        {
            if (openers.Contains(c))
            {
                openPair.Push(c);
            }
            
            if (c.Equals(']'))
            {
                if (openPair.Pop() != "]") return false;
            }

            if (c.Equals('}'))
            {
                if (openPair.Pop() != "}") return false;
            }

            if (c.Equals(')'))
            {
                if (openPair.Pop() != "(") return false;
            }
        }

        return openPair.Count == 0;
    }
}
