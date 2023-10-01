import java.util.HashMap;
import java.util.Map;

public class Blackjack {

    private static Map<String, Integer> cardValue;

    static {
        cardValue = new HashMap<>();
        cardValue.put("ace", 11);
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

    }

    public int parseCard(String card) {
        return cardValue.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        throw new UnsupportedOperationException("Please implement the Blackjack.isBlackjack method");
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        throw new UnsupportedOperationException("Please implement the Blackjack.largeHand method");
    }

    public String smallHand(int handScore, int dealerScore) {
        throw new UnsupportedOperationException("Please implement the Blackjack.smallHand method");
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
