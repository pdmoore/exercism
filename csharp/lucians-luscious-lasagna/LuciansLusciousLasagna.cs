class Lasagna
{
    private int expectedMinutesInOven = 40;
    private int preparationTimePerLayer = 2;
    
    public int ExpectedMinutesInOven()
    {
        return expectedMinutesInOven;
    }

    public int RemainingMinutesInOven(int timeAlreadyInOven)
    {
        return ExpectedMinutesInOven() - timeAlreadyInOven;
    }

    public int PreparationTimeInMinutes(int numberOfLayers)
    {
        return preparationTimePerLayer * numberOfLayers;
    }

    public int ElapsedTimeInMinutes(int numberOfLayers, int timeAlreadyInOven)
    {
        return PreparationTimeInMinutes(numberOfLayers) + timeAlreadyInOven;
    }
}
