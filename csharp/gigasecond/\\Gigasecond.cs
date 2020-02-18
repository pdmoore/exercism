using System;

public static class Gigasecond
{
    private const int NO_HOURS   = 0;
    private const int NO_MINUTES = 0;
    private static int GIGA_SECONDS = Convert.ToInt32(Math.Pow(10, 9));
    private static TimeSpan ONE_GIGASECOND = new TimeSpan(NO_HOURS, NO_MINUTES, GIGA_SECONDS);

    public static DateTime Add(DateTime birthDate)
    {
        return birthDate.Add(ONE_GIGASECOND);
    }
}