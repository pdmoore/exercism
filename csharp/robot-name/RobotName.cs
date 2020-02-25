using System;

public class Robot
{
    private const String PREFIX = "AB";
    private static int counter;
    private String name;
    
    public Robot()
    {
        name = PREFIX + counter.ToString("D3");
        ++counter;
    }

    public string Name
    {
        get
        {
            return name;
        }
    }

    public void Reset()
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}