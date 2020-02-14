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
        var sortScores = new List<int>(list);
        sortScores.Sort();
        
        // sortScores.Reverse();
        var numberToReturn = Math.Min(3, sortScores.Count);
        var topNScores = sortScores.GetRange(sortScores.Count - numberToReturn, numberToReturn);
        // var topNScores = sortScores.GetRange(0, numberToReturn);
        topNScores.Reverse();
        return topNScores;
    }
}