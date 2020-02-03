using System;

public class SpaceAge {
    private const double SECONDS_PER_EARTH_YER = 31557600;

    private readonly long _ageInSeconds;

    public SpaceAge(long ageInSeconds) {
        this._ageInSeconds = ageInSeconds;
    }

    public double OnEarth() {
        return ToTwoDecimals(_ageInSeconds / SECONDS_PER_EARTH_YER);
    }


    public double OnMercury() {
        var MercuryOfEarth = 0.2408467;

        return ToTwoDecimals(_ageInSeconds / (SECONDS_PER_EARTH_YER * MercuryOfEarth));
    }

    public double OnVenus() {
        var VenusOfEarth = 0.61519726;

        return ToTwoDecimals(_ageInSeconds / (SECONDS_PER_EARTH_YER * VenusOfEarth));
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

    private double ToTwoDecimals(double age) {
        return Math.Round(age, 2);
    }
}
