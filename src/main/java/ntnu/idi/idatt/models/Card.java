package ntnu.idi.idatt.models;

public class Card {
  private final char suit;
  private final char value;

  public Card(char suit, char value) {
    this.suit = suit;
    this.value = value;
  }

  public char getSuit() {
    return suit;
  }

  public char getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "" + value + suit;
  }
}
