using System;
using System.Collections.Generic;
using System.Linq;

public static class ListOps
{
    public static int Length<T>(List<T> input) => input.Count;

    public static List<T> Reverse<T>(List<T> input)
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public static List<TOut> Map<TIn, TOut>(List<TIn> input, Func<TIn, TOut> map) => 
        input.Select(map).ToList();

    public static List<T> Filter<T>(List<T> input, Func<T, bool> predicate) => 
        input.Where(predicate).ToList();

    public static TOut Foldl<TIn, TOut>(List<TIn> input, TOut start, Func<TOut, TIn, TOut> func) => 
        input.Aggregate(start, (current, item) => func(current, item));

    public static TOut Foldr<TIn, TOut>(List<TIn> input, TOut start, Func<TIn, TOut, TOut> func)
    {
        var list = input;
        list.Reverse();
        foreach (var item in list)
        {
            start = func(item, start);
        }

        return start;
        
    }

    public static List<T> Concat<T>(List<List<T>> input)
    {
        List<T> result = new List<T>();
        foreach (var list in input)
        {
            result.AddRange(list);
        }

        return result;
    }

    public static List<T> Append<T>(List<T> left, List<T> right)
    {
        List<T> result = new List<T>();
        result.AddRange(left);
        result.AddRange(right);
        return result;
    }
}