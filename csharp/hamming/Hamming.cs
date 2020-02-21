using System;
using System.Linq;

public static class Hamming
{
    public static int Distance(string firstStrand, string secondStrand)
    {
        return firstStrand.
            Zip(secondStrand).
            Count(x => !x.First.Equals(x.Second));
    }
}