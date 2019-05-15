package oop;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class popup {

    public static void show(String Sisu) {
        Stage lava = new Stage();
        lava.initModality(Modality.APPLICATION_MODAL);
        lava.setTitle("Tähelepanu!");

        VBox vb = new VBox(10);
        vb.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label(Sisu);
        Button button = new Button("OK");
        button.setOnAction(event -> {
            lava.close();
        });

        vb.getChildren().addAll(label, button);

        Scene popup = new Scene(vb);

        lava.setScene(popup);
        lava.sizeToScene();
        lava.setResizable(false);
        lava.showAndWait();
    }
}
