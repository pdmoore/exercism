using System;
using System.IO;
using System.Runtime.CompilerServices;

public static class Tournament
{
    private const string ColumnSeparator = "|";

    public static void Tally(Stream inStream, Stream outStream)
    {
        //TODO - split the header into it's own thing, format to ensure spacing is correct    
        StreamWriter sw = new StreamWriter(outStream);
        // sw.Write("Team                           ");
        sw.Write("Team".PadRight(31, ' '));
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

        sw.Flush();
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
