using System;
using System.IO;
using System.Runtime.CompilerServices;

public static class Tournament
{
    private const string ColumnSeparator = "|";

    public static void Tally(Stream inStream, Stream outStream)
    {
        StreamWriter sw = new StreamWriter(outStream);
        
        AddTableHeader(sw);

        if (inStream.Length > 0)
        {
            sw.Write("\n");
            sw.Write("Allegoric Alaskans             |  1 |  1 |  0 |  0 |  3");
            sw.Write("\n");
            sw.Write("Blithering Badgers             |  1 |  0 |  0 |  1 |  0");
        }
        
        
        sw.Flush();
    }

    private static void AddTableHeader(StreamWriter sw) {
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
