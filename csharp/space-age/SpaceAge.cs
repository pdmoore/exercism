using System;

public class SpaceAge {
    private const double SECONDS = 31557600;

    private readonly long seconds;

    public SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    public double OnEarth() {
        return ToTwoDecimals(seconds / SECONDS);
    }

    private double ToTwoDecimals(double age) {
        return Math.Round(age, 2);
    }

    public double OnMercury() {
        var MercuryOfEarth = 0.2408467;

        return ToTwoDecimals(seconds / (SECONDS * MercuryOfEarth));
    }

    public double OnVenus() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnMars() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnJupiter() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnSaturn() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnUranus() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnNeptune() {
        throw new NotImplementedException("You need to implement this function.");
    }
}