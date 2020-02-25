using System;

public class Robot
{
    private const string Prefix = "AB";
    private static int _counter;

    public Robot()
    {
        generateNewName();
    }

    private void generateNewName() {
        Name = Prefix + _counter.ToString("D3");
        ++_counter;
    }

    public string Name { get; set; }

    public void Reset()
    {
        generateNewName();
    }
}