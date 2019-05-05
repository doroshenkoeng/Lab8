package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**This class is created for launching javaFX GUI.*/
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        ImageView imageView = new ImageView(new Image("pictures/background.jpg"));
        Button button = new Button("", new ImageView(new Image("pictures/playbutton.png")));
        AnchorPane.setLeftAnchor(button, 450.0);
        AnchorPane.setTopAnchor(button, 600.0);
        button.setShape(new Circle(1.5));
        Label label = new Label();
        label.setTextFill(Color.AQUA);
        label.setFont(new Font(80));
        AnchorPane.setLeftAnchor(label, 250.0);
        AnchorPane.setTopAnchor(label, 200.0);
        TextField textField = new TextField("CardsNumber");
        AnchorPane.setLeftAnchor(textField, 260.0);
        AnchorPane.setTopAnchor(textField, 400.0);
        textField.setStyle("-fx-text-inner-color: aqua; -fx-font-size: 25px;");
        textField.setPrefSize(500, 50);
        button.setOnMouseClicked(ae -> {
            String content = textField.getText();
            if (content.compareTo("") == 0 || content.compareTo("CardsNumber")==0) new Controller().playGame(label, 36);
            else new Controller().playGame(label, Integer.parseInt(content));
        });
        root.getChildren().addAll(imageView, button, label, textField);
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
