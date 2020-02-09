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
        list.Sort();  // seems like this will break Latest - missing test?

        var numberToReturn = Math.Min(3, list.Count);
        var x = list.GetRange(list.Count - numberToReturn, numberToReturn);
        x.Reverse();
        return x;
    }
}