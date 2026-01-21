class Lasagna
{
    // TODO: define the 'ExpectedMinutesInOven()' method

    // TODO: define the 'RemainingMinutesInOven()' method

    // TODO: define the 'PreparationTimeInMinutes()' method

    // TODO: define the 'ElapsedTimeInMinutes()' method
    public int ExpectedMinutesInOven()
    {
        return 40;
    }

    public int RemainingMinutesInOven(int timeAlreadyInOven)
    {
        return ExpectedMinutesInOven() - timeAlreadyInOven;
    }

    public int PreparationTimeInMinutes(int numberOfLayers)
    {
        return 2 * numberOfLayers;
    }

    public int ElapsedTimeInMinutes(int numberOfLayers, int timeAlreadyInOven)
    {
        return PreparationTimeInMinutes(numberOfLayers) + timeAlreadyInOven;
    }
}
