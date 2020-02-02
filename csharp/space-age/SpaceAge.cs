using System;

public class SpaceAge {
    private const double SECONDS = 31557600;
    
    private long seconds;

    public SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    public double OnEarth() {
        return Math.Round(seconds / SECONDS, 2);
    }

    public double OnMercury()
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnVenus()
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnMars()
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnJupiter()
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnSaturn()
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnUranus()
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnNeptune()
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}