using System.Collections.Generic;
using System.Linq;

public static class SumOfMultiples
{
    public static int Sum(IEnumerable<int> multiples, int max)
    {
        return Enumerable.Range(0, max)
            .Where(j => multiples.Any(k => (j % k) == 0))
            .Sum();
    }
}