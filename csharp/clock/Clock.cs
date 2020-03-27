using System;
using System.Text;

public class Clock
{
    private int _hours;
    private int _minutes;

    public Clock(int hours, int minutes)
    {
        _hours = hours;
        _minutes = minutes;
    }

    public Clock Add(int minutesToAdd)
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public Clock Subtract(int minutesToSubtract)
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public override string ToString()
    {
        StringBuilder sb = new StringBuilder();
        sb.Append(_hours.ToString("D2"));
        sb.Append(":");
        sb.Append(_minutes.ToString("D2"));
        return sb.ToString();
    }
}
