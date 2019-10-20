import java.util.Arrays;

class Yacht {

    private final int[] dice;
    private final YachtCategory category;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.category = yachtCategory;
    }

    int score() {
        switch (category) {
            case YACHT:
                return scoreYacht();
            case ONES:
                return scoreMatchingDice(1);
            case TWOS:
                return scoreMatchingDice(2);
            case THREES:
                return scoreMatchingDice(3);
            case FOURS:
                return scoreMatchingDice(4);
            case FIVES:
                return scoreMatchingDice(5);
            case SIXES:
                return scoreMatchingDice(6);
            case FULL_HOUSE:
                return scoreFullHouse();
            case FOUR_OF_A_KIND:
                return scoreFourOfAKind();
            case LITTLE_STRAIGHT:
                return scoreLittleStraight();
            case BIG_STRAIGHT:
                return scoreBigStraight();
            case CHOICE:
                return sumOfDice();
        }
        return 0;
    }

    private boolean isStraight(int startWith) {
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] != startWith++) return false;
        }
        return true;
    }

    private int scoreLittleStraight() {
        Arrays.sort(dice);
        if (isStraight(1)) {
            return 30;
        }

        return 0;
    }

    private int scoreBigStraight() {
        Arrays.sort(dice);
        if (isStraight(2)) {
            return 30;
        }

        return 0;
    }

    private int scoreFourOfAKind() {
        Arrays.sort(dice);
        int countOfMatchingFirstDie = (int) Arrays.stream(dice).filter(n -> n == dice[0]).count();
        int countOfMatchingLast = (int) Arrays.stream(dice).filter(n -> n == dice[4]).count();
        if (countOfMatchingFirstDie >= 4) {
            return 4 * dice[0];
        } else if (countOfMatchingLast == 4) {
            return 4 * dice[4];
        }

        return 0;
    }

    private int scoreFullHouse() {
        Arrays.sort(dice);
        if ((dice[0] != dice[1]) || (dice[3] != dice[4])) {
            return 0;
        }

        if (dice[2] != dice[0] && dice[2] != dice[3]) {
            return 0;
        }

        return sumOfDice();
    }

    private int sumOfDice() {
        return Arrays.stream(dice).sum();
    }

    private int scoreMatchingDice(int whichDie) {
        int diesThatMatch = (int) Arrays.stream(dice).filter(n -> n == whichDie).count();
        return diesThatMatch * whichDie;
    }

    private int scoreYacht() {
        int diceValue = dice[0];
        if (Arrays.stream(dice).allMatch(n -> n == diceValue)) {
            return 50;
        }
        return 0;
    }

}
