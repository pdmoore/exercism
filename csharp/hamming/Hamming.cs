using System;
using System.Linq;

public static class Hamming
{
    public static int Distance(string firstStrand, string secondStrand)
    {

        var result = firstStrand.Zip(secondStrand);
        // return result.Select(x => x.First.Equals(x.Second)).Count();
        return result.Count(x => !x.First.Equals(x.Second));
    }
}