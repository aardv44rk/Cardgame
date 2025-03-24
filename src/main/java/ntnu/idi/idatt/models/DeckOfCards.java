package ntnu.idi.idatt.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};

  private final char[] values = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
  
  private List<Card> cards;

  public DeckOfCards() {
    cards = new ArrayList<>();
    for (char suit : suits) {
      for (char value : values) {
        Card card = new Card(suit, value);
        cards.add(card);
       }
    }
  }

  public List<Card> dealHand(int n) {
    List<Card> hand = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      hand.add(dealCard());
    }
    return hand;
  }

  public Card dealCard() {
    if (cards.isEmpty()) {
      throw new IllegalStateException("No more cards in the deck");
    }
    return cards.remove(cards.size() - 1);
  }

  /**
   * Implementation of Fisher-Yates shuffle algorithm.
   * Shuffles deck of cards, {@link #cards}.
   */
  public void shuffle() {
    Random random = new Random();
    for (int i = cards.size() - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      Card temp = cards.get(i);
      cards.set(i, cards.get(j));
      cards.set(j, temp);
    }
  }

  public int getNumberOfCards() {
    return cards.size();
  }
}
