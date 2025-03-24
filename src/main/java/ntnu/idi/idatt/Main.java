package ntnu.idi.idatt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntnu.idi.idatt.views.CardGameView;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        CardGameView view = new CardGameView();
        Scene scene = new Scene(view, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Card Game");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}