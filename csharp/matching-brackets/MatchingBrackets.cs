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
        
        int bracketCount = 0;
        int curlyCount = 0;
        int parenCount = 0;
        foreach (char c in input)
        {
            if (c.Equals('['))
            {
                bracketCount++;
                openPair.Push(c);
            } else if (c.Equals(']'))
            {
                if (openPair.Pop() != "]") return false;
                bracketCount--;
            }
            
            if (c.Equals('{'))
            {
                curlyCount++;
                openPair.Push(c);
            } else if (c.Equals('}'))
            {
                if (openPair.Pop() != "}") return false;
                curlyCount--;
            }

            if (c.Equals('('))
            {
                parenCount++;
                openPair.Push(c);
            } else if (c.Equals(')'))
            {
                if (openPair.Pop() != "(") return false;
                parenCount--;
            }

            // return openPair.Count == 0;
        }
        
        // return bracketCount == 0 && curlyCount == 0 && parenCount == 0;
        return openPair.Count == 0;
    }
}
