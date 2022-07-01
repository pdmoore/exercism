class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean everyoneIsAwake = (knightIsAwake && archerIsAwake && prisonerIsAwake);
        boolean bothFoesAreSleeping = !knightIsAwake && !archerIsAwake;

        if ((prisonerIsAwake && bothFoesAreSleeping) ||
        (prisonerIsAwake && !knightIsAwake) ||
        (prisonerIsAwake && !archerIsAwake) ||
                (!bothFoesAreSleeping && !prisonerIsAwake) ||
        everyoneIsAwake) {
            return true;
        }

        return false;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        boolean foesAreAsleep = !knightIsAwake && !archerIsAwake;

        if (petDogIsPresent) {
            if (knightIsAwake && !archerIsAwake && !prisonerIsAwake) return true;
            if (!foesAreAsleep && !prisonerIsAwake) return false;
            if (!archerIsAwake) return true;
            if (prisonerIsAwake && !foesAreAsleep) return false;
        }

        return petDogIsPresent || (prisonerIsAwake && foesAreAsleep);


    }
}
