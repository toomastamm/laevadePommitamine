package oop;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class m_inimene extends Mängija {

    public m_inimene(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    /**
     * Küsib kasutajalt kordinaate ja suunda, et paigutada laev
     *
     * @param pikkus kui pikk on laev, mida paigutada
     * @return boolean kas sai paigutatud
     */
    @Override
    void paigutaLaev(int pikkus) {
        Stage lava = new Stage();
        lava.setTitle(this.getNimi() + " - Paiguta laev pikkusega " + pikkus);
        int nuppe_reas = this.getMänguväli().getPikkus();
        GridPane gp = new GridPane();


        CheckBox rotate = new CheckBox("Roteeri");
        for (int i = 0; i < nuppe_reas; i++) {
            for (int j = 0; j < nuppe_reas; j++) {
                final int y = j;
                final int x = i;
                String tekst = this.getMänguväli().getSisu(x, y);
                Button button = new Button();
                button.setText(tekst);
                if (tekst.equals(Väli.laev)) {
                    button.setStyle("-fx-font-weight: bold;");
                }
                button.setOnAction(event -> {
                    boolean paigutus = prooviPaigutada(y, x, pikkus, rotate.isSelected());
                    if (paigutus) {
                        lava.hide();
                    }
                });

                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);
                gp.add(button, j, i);
                gp.setHgrow(button, Priority.ALWAYS);
                gp.setVgrow(button, Priority.ALWAYS);
            }
        }


        gp.add(rotate, nuppe_reas, 0);
        Scene mängija = new Scene(gp, 500, 500);
        lava.setScene(mängija);
        lava.sizeToScene();
        lava.minHeightProperty().bind(lava.widthProperty().multiply(1));
        lava.maxHeightProperty().bind(lava.widthProperty().multiply(1));
        lava.showAndWait();
    }

    @Override
    public void käik(Mängija vastane, Stage lava) {
        lava.setTitle(this.getNimi() + " kord lasta:");
        int nuppe_reas = this.getMänguväli().getPikkus();
        GridPane gp = new GridPane();

        for (int i = 0; i < nuppe_reas; i++) {
            for (int j = 0; j < nuppe_reas; j++) {
                final int y = j;
                final int x = i;
                String tekst = vastane.getMänguväli().getSisu(x, y);
                if (tekst.equals(Väli.laev)) {
                    tekst = Väli.tavaline;
                }
                Button button = new Button(tekst);
                button.setText(tekst);
                if (!tekst.equals(Väli.tavaline)) {
                    button.setStyle("-fx-font-weight: bold;");
                }
                if (tekst.equals(Väli.pihtas)) {
                    button.setStyle("-fx-text-fill: red;");
                }

                button.setOnAction(event -> {
                    try {
                        boolean pihtas = vastane.vastaseLask(x, y);
                        if (pihtas && !vastane.getMänguväli().laevuPole()) {
                            this.käik(vastane, lava);
                        } else {
                            if (!vastane.getMänguväli().laevuPole()) {
                                popup.show("Vajuta OK, et vahetada mängijat");
                            }
                            lava.close();
                        }
                    } catch (JubaLastudErind e) {
                        popup.show("Juba lasid valitud ruudule, proovi midagi muud");
                    }
                });

                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);
                gp.setHgrow(button, Priority.ALWAYS);
                gp.setVgrow(button, Priority.ALWAYS);
                gp.add(button, j, i);
            }
        }
        Scene mängija = new Scene(gp);
        lava.minHeightProperty().bind(lava.widthProperty().multiply(1));
        lava.maxHeightProperty().bind(lava.widthProperty().multiply(1));
        lava.setScene(mängija);
        lava.sizeToScene();
        if (!lava.isShowing()) {
            lava.showAndWait();
        }
    }


}
