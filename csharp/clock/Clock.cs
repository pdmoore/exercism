using System;
using System.Text;

public class Clock
{
    private readonly int _minutes;
    private readonly string TwoDecimalPlaces = "D2";
    private readonly int HoursPerDay = 24;
    private readonly int MinutesPerHour = 60;

    public Clock(int hours, int minutes) => _minutes = minutes + (ReduceHours(hours) * 60);

    private int ReduceHours(in int hours)
    {
        int totalHours = hours % HoursPerDay;

        if (totalHours < 0)
        {
            totalHours += HoursPerDay;
        }
        
        return totalHours;
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
        // should this reduce happen in ctor?
        int hours = ReduceHours(_minutes / MinutesPerHour); 
        int minutes = _minutes % MinutesPerHour;

        StringBuilder sb = new StringBuilder();
        sb.Append(hours.ToString(TwoDecimalPlaces));
        sb.Append(":");
        sb.Append(minutes.ToString(TwoDecimalPlaces));
        return sb.ToString();
    }
}
