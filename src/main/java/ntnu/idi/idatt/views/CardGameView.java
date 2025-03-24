package ntnu.idi.idatt.views;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ntnu.idi.idatt.controllers.CardGameController;
import ntnu.idi.idatt.models.Card;

public class CardGameView extends VBox {
  private CardGameController controller;
  private Label cardsLabel;
  private Label sumLabel;
  private Label heartsLabel;
  private Label qosLabel;
  private Label flushLabel;
  private TextField numCardsField;

  public CardGameView() {
    setPadding(new Insets(20));
    setSpacing(10);

    controller = new CardGameController();

    HBox inputBox = new HBox(10);
    Label numCardsLabel = new Label("Number of cards:");
    numCardsField = new TextField("5");
    numCardsField.setPrefWidth(50);
    inputBox.getChildren().addAll(numCardsLabel, numCardsField);

    // Deal hand button
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(e -> dealHand());

    Button checkButton = new Button("Check hand");
    checkButton.setOnAction(e -> checkHand());

    // result labels
    cardsLabel = new Label("Cards: ");
    sumLabel = new Label("Sum: ");
    heartsLabel = new Label("Hearts: ");
    qosLabel = new Label("Q of Spades: ");
    flushLabel = new Label("Flush: ");

    getChildren().addAll(
      inputBox,
      dealButton,
      checkButton,
      cardsLabel,
      sumLabel,
      heartsLabel,
      qosLabel,
      flushLabel
    );
  }

  private void dealHand() {
    try {
      int numCards = Integer.parseInt(numCardsField.getText());
      if (numCards < 1 || numCards > 52) {
        cardsLabel.setText("Number of cards must be between 1 and 52");
        return;
      }

      controller.dealNewHand(numCards);
      displayCards();

      sumLabel.setText("Sum: ");
      heartsLabel.setText("Hearts: ");
      qosLabel.setText("Q of Spades: ");
      flushLabel.setText("Flush: ");

    } catch (NumberFormatException e) {
      cardsLabel.setText("Invalid number of cards");
    }
  }

  private void displayCards() {
    List<Card> hand = controller.getCurrentHand();
    if (hand == null || hand.isEmpty()) {
      cardsLabel.setText("No hand dealt");
      return;
    }

    StringBuilder sb = new StringBuilder("Cards: ");

    for (Card card : hand) {
      sb.append(card).append(" ");
    }
    cardsLabel.setText(sb.toString());
  }

  private void checkHand() {
    if (controller.getCurrentHand() == null || controller.getCurrentHand().isEmpty()) {
      cardsLabel.setText("No hand dealt");
      return;
    }

    sumLabel.setText("Sum: " + controller.getSum());
    heartsLabel.setText("Hearts: " + controller.getHeartsAsString());
    qosLabel.setText("Q of Spades: " + controller.hasQos());
    flushLabel.setText("Flush: " + controller.hasFlush());
  }
}
