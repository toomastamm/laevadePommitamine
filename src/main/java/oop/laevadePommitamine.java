package oop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class laevadePommitamine extends Application {

    Mäng mäng;

    @Override
    public void start(Stage peaLava) {
        peaLava.setTitle("Laevade pommitamine");

        VBox vb = new VBox(10);
        vb.setPadding(new Insets(10, 10, 10, 10));

        Button alusta = new Button("Alusta");
        Button skoorid = new Button("Skoorid");
        Button sulge = new Button("Sulge");
        alusta.setOnAction(event -> {
            peaLava.hide();
            mäng_pealoop();
            peaLava.show();
        });
        skoorid.setOnAction(event -> {
            peaLava.hide();
            Skoor_controller sc = new Skoor_controller("skoorid.bin");
            sc.näite_skoore();
            peaLava.show();
        });
        sulge.setOnAction(event -> {
            peaLava.close();
        });
        vb.getChildren().addAll(alusta, skoorid, sulge);
        Scene menüü = new Scene(vb);
        peaLava.setScene(menüü);
        peaLava.setResizable(false);
        peaLava.sizeToScene();
        peaLava.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void mäng_pealoop() {
        uus_mäng();
        mäng.laevadePaigutamine();
        mäng.alustaMäng();
    }

    public void uus_mäng() {
        Stage lava = new Stage();
        lava.setTitle("Sisesta mängijad");

        //Mängijad
        TextField nimi1 = new TextField("Mängija 1 nimi");
        CheckBox arvuti1 = new CheckBox("Arvuti");
        TextField nimi2 = new TextField("Mängija 2 nimi");
        CheckBox arvuti2 = new CheckBox("Arvuti");
        Button alusta = new Button("Alusta");

        VBox vb = new VBox(10);
        vb.getChildren().addAll(nimi1, arvuti1, nimi2, arvuti2, alusta);

        Scene mängijad = new Scene(vb);

        alusta.setOnAction(event -> {
            Mängija mängija1;
            Mängija mängija2;

            if (arvuti1.isSelected()) {
                mängija1 = new m_arvuti(nimi1.getText(), 10);
            } else {
                mängija1 = new m_inimene(nimi1.getText(), 10);
            }

            if (arvuti2.isSelected()) {
                mängija2 = new m_arvuti(nimi2.getText(), 10);
            } else {
                mängija2 = new m_inimene(nimi2.getText(), 10);
            }
            alusta.setDisable(true);
            this.mäng = new Mäng(mängija1, mängija2);
            lava.hide();
        });

        lava.setScene(mängijad);
        lava.sizeToScene();
        lava.setResizable(false);
        lava.showAndWait();
    }
}
