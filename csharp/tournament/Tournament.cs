using System;
using System.IO;
using System.Runtime.CompilerServices;
using System.Xml.Schema;

public static class Tournament
{
    private static readonly int TeamNameWidth = 31;
    private const string ColumnSeparator = "|";

    public static void Tally(Stream inStream, Stream outStream)
    {
        StreamWriter sw = new StreamWriter(outStream);

        AddTableHeader(sw);

        // TODO likely move all of this above line 11 and create the list of teams/wins/losses/draws
        if (inStream.Length > 0)
        {
            StreamReader sr = new StreamReader(inStream);

            //TODO loop over this while sr has something in it
            var line = sr.ReadLine();

            // AA win
            // BB loss
            // "Allegoric Alaskans;Blithering Badgers;win";
            // TODO not paying attention to the last element!?!?
            var lineElements = line.Split(";");
            var teamStat1 = new TeamStatistic {Name = lineElements[0]};
            var teamStat2 = new TeamStatistic {Name = lineElements[1]};
            if (lineElements[2] == "win")
            {
                teamStat1.AddWin();
                teamStat2.AddLoss();
                
                sw.Write("\n");
                sw.Write(teamStat1.ToString());
                sw.Write("\n");
                sw.Write(teamStat2.ToString());
            }
            else // TODO assuming not a win is a loss, need to check for draw/loss
            {
                teamStat1.AddLoss();
                teamStat2.AddWin();

                sw.Write("\n");
                sw.Write(teamStat2.ToString());
                sw.Write("\n");
                sw.Write(teamStat1.ToString());
            }


            // TODO - this will loop over all teams & stats
            // alphabetical team name order?
            // Track stats and calculate a score based on stats
            // maybe ask the teamStatistic to print itself?
            
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
    private int _wins;
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
        result += _wins.ToString().CenterTitle();
        result += "|";
        result += _draws.ToString().CenterTitle();
        result += "|";
        result += _losses.ToString().CenterTitle();
        result += "|";
        result += Score().ToString().PadLeft(3);
        return result;
    }

    private int Score() => (3 * _wins) + _draws;


    public void AddWin()
    {
        _matchesPlayed++;
        _wins++;
    }

    public void AddLoss()
    {
        _matchesPlayed++;
        _losses++;
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