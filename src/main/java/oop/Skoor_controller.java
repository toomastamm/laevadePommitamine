package oop;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Skoor_controller {
    ArrayList<Skoor> skoorid;

    public Skoor_controller(ArrayList<Skoor> skoorid) {
        this.skoorid = skoorid;
        trimmi_kümneks();
    }

    public Skoor_controller(String failinimi) {
        ArrayList<Skoor> skoorid = new ArrayList<>();

        try (DataInputStream dos = new DataInputStream(new FileInputStream(failinimi))) {
            int kogus = dos.readInt();
            for (int i = 0; i < kogus; i++) {
                String nimi = dos.readUTF();
                int käike = dos.readInt();
                Skoor skoor = new Skoor(käike, nimi);
                skoorid.add(skoor);
            }

        } catch (Exception e) {
            System.out.println("Skooride faili pole, võtame tühja array");
        }

        this.skoorid = skoorid;
        trimmi_kümneks();
    }

    private void trimmi_kümneks() {
        Collections.sort(skoorid);
        while (skoorid.size() > 10) {
            skoorid.remove(10);
        }
    }

    public ArrayList<Skoor> getSkoorid() {
        return skoorid;
    }

    public void näite_skoore() {
        Stage lava = new Stage();
        lava.setTitle("High-Scores");

        VBox vb = new VBox(10);
        vb.setPadding(new Insets(10, 10, 10, 10));

        if (skoorid.size() == 0) {
            Label label = new Label("Skoore pole");
            vb.getChildren().add(label);
        } else {
            int i = 1;
            for (Skoor skoor : skoorid) {
                Label label = new Label(i++ + ". " + skoor.toString() );
                vb.getChildren().add(label);
            }
        }

        Button button = new Button("Sulge");
        button.setOnAction(event -> {
            lava.close();
        });
        vb.getChildren().add(button);
        Scene skoorid = new Scene(vb);
        lava.setScene(skoorid);
        lava.setResizable(false);
        lava.sizeToScene();
        lava.showAndWait();
    }

    public void lisa_skoor(String nimi, int käike) {
        skoorid.add(new Skoor(käike, nimi));
        trimmi_kümneks();
    }

    public void salvesta_skoorid(String failinimi) {
        trimmi_kümneks();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(failinimi))) {
            dos.writeInt(skoorid.size());
            for (Skoor skoor : skoorid) {
                dos.writeUTF(skoor.nimi);
                dos.writeInt(skoor.käik);
            }

        } catch (Exception e) {
            System.exit(0);
        }
    }
}
