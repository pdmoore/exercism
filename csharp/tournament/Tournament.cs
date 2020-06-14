using System;
using System.IO;

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
        sw.Write(" MP |  W |  D |  L |  P");
        
        sw.Flush();
    }
}
