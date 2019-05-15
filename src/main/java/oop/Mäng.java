package oop;

import javafx.stage.Stage;

public class Mäng {
    Mängija mängija1;
    Mängija mängija2;
    int käik = 0;

    public Mäng(Mängija mängija1, Mängija mängija2) {
        this.mängija1 = mängija1;
        this.mängija2 = mängija2;
    }


    public Mängija getMängija1() {
        return mängija1;
    }

    public Mängija getMängija2() {
        return mängija2;
    }

    @Override
    public String toString() {
        return String.format("Mängivad %s ja %s.", mängija1.getNimi(), mängija2.getNimi());
    }

    /**
     * Alustab laevade panemise faasi
     */
    public void laevadePaigutamine() {
        paigutaLaevad(mängija1);
        paigutaLaevad(mängija2);
    }

    /**
     * Annab käsu mängijale paigutada laev
     *
     * @param mängija objekt
     */
    private void paigutaLaevad(Mängija mängija) {
        popup.show("Vajuta OK, et vahetada mängijat");
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                mängija.paigutaLaev(i);
            }
        }
    }

    /**
     * Alustab mängu põhiosa ehk pommitamist
     */
    public void alustaMäng() {
        popup.show("Vajuta ok, et vahetada mängijat");

        pealoop:
        while (true) {
            this.käik += 1;
            Stage lava = new Stage();
            mängija1.käik(mängija2, lava);
            if (mängija2.getMänguväli().laevuPole()) {
                break;
            }
            this.käik += 1;
            lava = new Stage();
            mängija2.käik(mängija1, lava);
            if (mängija1.getMänguväli().laevuPole()) {
                break;
            }
        }

        Skoor_controller sc = new Skoor_controller("skoorid.bin");
        if (mängija1.getMänguväli().laevuPole()) {
            popup.show(mängija2.getNimi() + " võitis " + käik + " käiguga!");
            sc.lisa_skoor(mängija2.getNimi(), käik);
        } else {
            popup.show(mängija1.getNimi() + " võitis " + käik + " käiguga!");
            sc.lisa_skoor(mängija1.getNimi(), käik);
        }

        sc.salvesta_skoorid("skoorid.bin");
    }
}
