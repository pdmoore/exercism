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
        return prisonerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        throw new UnsupportedOperationException("Please implement the (static) AnnalynsInfiltration.canFreePrisoner() method");
    }
}
