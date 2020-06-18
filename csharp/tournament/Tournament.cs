﻿using System.Collections.Generic;
using System.IO;
using System.Linq;

public static class Tournament
{
    private static readonly int TeamNameWidth = 31;
    private const string ColumnSeparator = "|";

    public static void Tally(Stream inStream, Stream outStream)
    {
        StreamWriter sw = new StreamWriter(outStream);

        AddTableHeader(sw);

        Dictionary<string, TeamStatistic> teamStatistics = new Dictionary<string, TeamStatistic>();

        if (inStream.Length > 0)
        {
            StreamReader sr = new StreamReader(inStream);

            var line = sr.ReadLine();

            // TODO - lots of code for 'grab existing or create new'
            var lineElements = line.Split(";");
            TeamStatistic teamStat1;
            TeamStatistic teamStat2;
            if (teamStatistics.ContainsKey(lineElements[0]))
            {
                teamStat1 = teamStatistics[lineElements[0]];
            }
            else
            {
                teamStat1 = new TeamStatistic {Name = lineElements[0]};
                teamStatistics.Add(teamStat1.Name, teamStat1);
            }

            if (teamStatistics.ContainsKey(lineElements[1]))
            {
                teamStat2 = teamStatistics[lineElements[1]];
            }
            else
            {
                teamStat2 = new TeamStatistic {Name = lineElements[1]};
                teamStatistics.Add(teamStat2.Name, teamStat2);
            }
            
            switch (lineElements[2])
            {
                case "win":
                    teamStat1.AddWin();
                    teamStat2.AddLoss();
                    break;
                case "loss":
                    teamStat1.AddLoss();
                    teamStat2.AddWin();
                    break;
                default:
                    teamStat1.AddDraw();
                    teamStat2.AddDraw();
                    break;
            }
        }


        foreach (KeyValuePair<string, TeamStatistic> entry in teamStatistics.OrderByDescending(i => i.Value.Wins))
        {
            sw.Write("\n");
            sw.Write(entry.Value.ToString());
        }

        sw.Flush();
    }

    private static void AddTableHeader(StreamWriter sw)
    {
        sw.Write("Team".PadRight(TeamNameWidth, ' '));
        sw.Write(ColumnSeparator);
        sw.Write("MP".CenterTitle());
        sw.Write(ColumnSeparator);
        sw.Write("W".CenterTitle());
        sw.Write(ColumnSeparator);
        sw.Write("D".CenterTitle());
        sw.Write(ColumnSeparator);
        sw.Write("L".CenterTitle());
        sw.Write(ColumnSeparator);
        sw.Write("P".PadLeft(3));
    }
}

internal class TeamStatistic
{
    public string Name;
    private int _matchesPlayed;
    public int Wins;
    private int _losses;
    private int _draws;

    public override string ToString()
    {
        //TODO - consts don't carry over from other class
        string result = "";
        result += Name.PadRight(31);
        result += "|";
        result += _matchesPlayed.ToString().CenterTitle();
        result += "|";
        result += Wins.ToString().CenterTitle();
        result += "|";
        result += _draws.ToString().CenterTitle();
        result += "|";
        result += _losses.ToString().CenterTitle();
        result += "|";
        result += Score().ToString().PadLeft(3);
        return result;
    }

    private int Score() => (3 * Wins) + _draws;


    public void AddWin()
    {
        _matchesPlayed++;
        Wins++;
    }

    public void AddLoss()
    {
        _matchesPlayed++;
        _losses++;
    }

    public void AddDraw()
    {
        _draws++;
        _matchesPlayed++;
    }
}

public static class StringExtensions
{
    public static string CenterTitle(this string str, int totalWidth = 4, char paddingChar = ' ')
    {
        int padding = totalWidth - str.Length;
        int padLeft = 0;
        if (str.Length % 2 == 0)
        {
            padLeft = padding / 2 + str.Length;
        }
        else
        {
            padLeft = padding / 2 + str.Length + 1;
        }

        return str.PadLeft(padLeft, paddingChar).PadRight(totalWidth, paddingChar);
    }
}