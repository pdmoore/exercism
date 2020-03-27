using System;
using System.Text;

public class Clock
{
    private readonly int _hours;
    private readonly int _minutes;
    private readonly string TwoDecimalPlaces = "D2";

    public Clock(int hours, int minutes)
    {
        _hours = ReduceHours(hours);
        _minutes = minutes + (_hours * 60);
    }

    private int ReduceHours(in int hours) => hours % 24;

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

        int hours = _minutes / 60;
        int minutes = _minutes % 60;



        sb.Append(hours.ToString(TwoDecimalPlaces));
        sb.Append(":");
        sb.Append(minutes.ToString(TwoDecimalPlaces));
        return sb.ToString();
    }
}
