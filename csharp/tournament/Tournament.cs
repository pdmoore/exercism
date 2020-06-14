using System;
using System.IO;
using System.Runtime.CompilerServices;

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
            var lineElements = line.Split(";");
            string team1 = lineElements[0];
            string team2 = lineElements[1];


            // TODO - this will loop over all teams & stats
            sw.Write("\n");
            sw.Write(team1.PadRight(TeamNameWidth));
            sw.Write("|  1 |  1 |  0 |  0 |  3");
            sw.Write("\n");
            sw.Write(team2.PadRight(TeamNameWidth));
            sw.Write("|  1 |  0 |  0 |  1 |  0");
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