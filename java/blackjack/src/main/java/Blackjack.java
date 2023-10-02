import java.util.HashMap;
import java.util.Map;

public class Blackjack {

    public static final String HIT = "H";
    public static final String SPLIT = "P";
    public static final String STAND = "S";
    public static final String WIN = "W";
    private static Map<String, Integer> cardValue;

    private enum options {
        STAND {
            @Override
            public String toString() {
                return "S";
            }
        },
        SPLIT {
            @Override
            public String toString() {
                return "P";
            }
        },
        WIN {
            @Override
            public String toString() {
                return "W";
            }
        },
        HIT {
            @Override
            public String toString() {
                return "H";
            }
        }
    }

    ;

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
        options strategy = options.STAND;
        if (isBlackjack && dealerScore < 10) {
            strategy = options.WIN;
        } else if (!isBlackjack) {
            strategy = options.SPLIT;
        }
        return strategy.toString();
    }

    public String smallHand(int handScore, int dealerScore) {
        options strategy = options.STAND;
        if ((handScore <= 11) ||
            (handScore < 17 && dealerScore >= 7))   {
            strategy = options.HIT;
        }
        return strategy.toString();
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
