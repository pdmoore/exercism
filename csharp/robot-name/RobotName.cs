using System;

public class Robot
{
    private const string Prefix = "AB";
    private static int _counter;

    public Robot()
    {
        Name = Prefix + _counter.ToString("D3");
        ++_counter;
    }

    public string Name { get; }

    public void Reset()
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}