using System;
using System.IO;

public static class Tournament
{   
    public static void Tally(Stream inStream, Stream outStream)
    {
        StreamWriter sw = new StreamWriter(outStream);
        sw.Write("Team                           | MP |  W |  D |  L |  P");
        sw.Flush();
    }
}
