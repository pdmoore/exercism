using System;
using System.Linq;

public static class Hamming
{
    public static int Distance(string firstStrand, string secondStrand)
    {
        if (!firstStrand.Length.Equals(secondStrand.Length))
        {
            throw new ArgumentException();
        }
        
        return firstStrand.
            Zip(secondStrand).
            Count(x => !x.First.Equals(x.Second));
    }
}