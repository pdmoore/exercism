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
        return list.LastOrDefault();
    }

    public int PersonalBest()
    {
        return list.Max();
    }

    public List<int> PersonalTopThree()
    {
        var sortedDescendingScores = new List<int>(list);
        sortedDescendingScores.Sort();
        sortedDescendingScores.Reverse();
        
        var numberOfScores = Math.Min(3, sortedDescendingScores.Count);
        return sortedDescendingScores.GetRange(0, numberOfScores);
    }
}