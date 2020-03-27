using System;
using System.Text;

public class Clock
{
    private readonly int _minutes;
    private readonly string TwoDecimalPlaces = "D2";

    public Clock(int hours, int minutes) => _minutes = minutes + (ReduceHours(hours) * 60);

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
        int hours = _minutes / 60;
        int minutes = _minutes % 60;

        StringBuilder sb = new StringBuilder();
        sb.Append(hours.ToString(TwoDecimalPlaces));
        sb.Append(":");
        sb.Append(minutes.ToString(TwoDecimalPlaces));
        return sb.ToString();
    }
}
