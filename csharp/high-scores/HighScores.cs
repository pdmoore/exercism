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
        throw new NotImplementedException();
    }

    public int PersonalBest()
    {
        throw new NotImplementedException();
    }

    public List<int> PersonalTopThree()
    {
        throw new NotImplementedException();
    }
}