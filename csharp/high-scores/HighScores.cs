using System;
using System.Collections.Generic;
using System.Linq;

public class HighScores
{
    private List<int> list;

    public HighScores(List<int> list)
    {
        this.list = list;
    }

    public List<int> Scores()
    {
        return list;
    }

    public int Latest()
    {
        return list.Last();
    }

    public int PersonalBest()
    {
        return list.Max();
    }

    public List<int> PersonalTopThree()
    {
        list.Sort();    // Sort is ascending order - can it be specified?
        list.Reverse();  // reverse the whole thing

        var numberToReturn = Math.Min(3, list.Count);
        return list.GetRange(0, numberToReturn);
    }
}