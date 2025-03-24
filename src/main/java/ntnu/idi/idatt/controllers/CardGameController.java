package ntnu.idi.idatt.controllers;

import java.util.List;
import java.util.stream.Collectors;

import ntnu.idi.idatt.models.Card;
import ntnu.idi.idatt.models.DeckOfCards;
import ntnu.idi.idatt.models.HandEvaluator;

public class CardGameController {
  private DeckOfCards deck;
  private List<Card> currentHand;

  public CardGameController() {
    deck = new DeckOfCards();
    deck.shuffle();
  }

  public void dealNewHand(int numberOfCards) {
    if (deck == null || numberOfCards > deck.getNumberOfCards()) {
      deck = new DeckOfCards();
      deck.shuffle();
    }
    currentHand = deck.dealHand(numberOfCards);
  }
  public List<Card> getCurrentHand() {
    return currentHand;
  }

  public int getSum() {
    if (currentHand == null || currentHand.isEmpty()) {
      return 0;
    }

    return currentHand.stream()
              .mapToInt(card -> {
                char value = card.getValue();
                if (value == 'A') return 1;
                else if (value == 'T') return 10;
                else if (value == 'J') return 11;
                else if (value == 'Q') return 12;
                else if (value == 'K') return 13;
                else return Character.getNumericValue(value);
              })
              .sum();
  }

  public String getHeartsAsString() {
    if (currentHand == null || currentHand.isEmpty()) {
      return "No cards dealt";
    }

    String hearts = currentHand.stream()
                      .filter(card -> card.getSuit() == 'H')
                      .map(Card::toString)
                      .collect(Collectors.joining(" "));

    return hearts.isEmpty() ? "No hearts" : hearts;
  }

  public boolean hasQos() {
    if (currentHand == null || currentHand.isEmpty()) {
      return false;
    }

    return currentHand.stream()
            .anyMatch(card -> card.getValue() == 'Q' && card.getSuit() == 'S');
  }

  public boolean hasFlush() {
    if (currentHand == null || currentHand.isEmpty()) {
      return false;
    }

    return HandEvaluator.isFlush(currentHand);
  }
}

