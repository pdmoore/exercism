import java.util.HashMap;
import java.util.Map;

public class Blackjack {
    private enum Decisions {
        STAND("S"),
        SPLIT("P"),
        WIN("W"),
        HIT("H");

        private final String decision;
        Decisions(String singleLetter) {
            this.decision = singleLetter;
        }

        @Override
        public String toString() {
            return decision;
        }
    }

    private static final Map<String, Integer> cardValue;
    static {
        cardValue = new HashMap<>();
        cardValue.put("two", 2);
        cardValue.put("three", 3);
        cardValue.put("four", 4);
        cardValue.put("five", 5);
        cardValue.put("six", 6);
        cardValue.put("seven", 7);
        cardValue.put("eight", 8);
        cardValue.put("nine", 9);
        cardValue.put("ten", 10);
        cardValue.put("jack", 10);
        cardValue.put("queen", 10);
        cardValue.put("king", 10);
        cardValue.put("ace", 11);
    }

    public int parseCard(String card) {
        return cardValue.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        return (21 == scoreHand(card1, card2));
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        Decisions decision = Decisions.STAND;
        if (isBlackjack && dealerScore < 10) {
            decision = Decisions.WIN;
        } else if (!isBlackjack) {
            decision = Decisions.SPLIT;
        }
        return decision.toString();
    }

    public String smallHand(int handScore, int dealerScore) {
        Decisions decision = Decisions.STAND;
        if ((handScore <= 11) ||
            (handScore < 17 && dealerScore >= 7))   {
            decision = Decisions.HIT;
        }
        return decision.toString();
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = scoreHand(card1, card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }

    private int scoreHand(String card1, String card2) {
        return parseCard(card1) + parseCard(card2);
    }
}
