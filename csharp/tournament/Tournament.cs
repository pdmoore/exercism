﻿using System;
using System.IO;

public static class Tournament
{   
    public static void Tally(Stream inStream, Stream outStream)
    {
        //TODO - split the header into it's own thing, format to ensure spacing is correct    
        StreamWriter sw = new StreamWriter(outStream);
        sw.Write("Team                           | MP |  W |  D |  L |  P");
        sw.Flush();
    }
}