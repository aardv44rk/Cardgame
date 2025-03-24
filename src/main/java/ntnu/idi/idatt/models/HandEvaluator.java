package ntnu.idi.idatt.models;

import java.util.List;

public class HandEvaluator {
  public static int getCardValue(char value) {
    return switch(value) {
              case 'A' -> 14;
              case 'K' -> 13;
              case 'Q' -> 12;
              case 'J' -> 11;
              case 'T' -> 10;
              default -> Character.getNumericValue(value);
            };
  }

  public static boolean isFlush(List<Card> hand) {
    return hand.stream()
            .map(Card::getSuit)
            .distinct()
            .count() == 1;
  }
}
