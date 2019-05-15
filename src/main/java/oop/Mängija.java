package oop;

import javafx.scene.Scene;
import javafx.stage.Stage;

abstract public class Mängija {
    private Väli mänguväli;
    private String nimi;

    public Mängija(String nimi, int pikkus) {
        this.mänguväli = new Väli(pikkus);
        this.nimi = nimi;
    }

    abstract void paigutaLaev(int pikkus);

    //abstract boolean lase(Mängija vastane);

    /**
     * Vaatab, kas on võimalik laeva paigutada, kui on, siis paigutab
     *
     * @param x      alguskordinaat
     * @param y      alguskordinaat
     * @param pikkus kui pikk laev
     * @param suund  laeva suund
     * @return
     */
    boolean prooviPaigutada(int x, int y, int pikkus, Boolean suund) {
        int delta_x = 0;
        int delta_y = 0;

        //Määra suund abimuutujasse, kontrolli kas laeva jaoks on ruumi
        if (suund) {
            delta_y = 1;

            //Kas mahub ära
            if (x + pikkus > getMänguväli().getPikkus()) {
                return false;
            }

            //Kas on laev 1 ruudu läheduses
            for (int j = -1; j < 2; j++) {
                for (int i = 0; i < pikkus + 2; i++) {
                    if (!(getMänguväli().getSisu(y + j, x + (i * delta_y) - 1).equals(Väli.tavaline)
                            || getMänguväli().getSisu(y + j, x + (i * delta_y) - 1).equals("Viga"))) {
                        return false;
                    }
                }
            }

        } else {
            delta_x = 1;

            //Kas mahub ära
            if (y + pikkus > getMänguväli().getPikkus()) {
                return false;
            }

            //Kas on laev 1 ruudu läheduses
            for (int j = -1; j < 2; j++) {
                for (int i = 0; i < pikkus + 2; i++) {
                    if (!(getMänguväli().getSisu(y + (i * delta_x) - 1, x + j).equals(Väli.tavaline)
                            || getMänguväli().getSisu(y + (i * delta_x) - 1, x + j).equals("Viga"))) {
                        return false;
                    }
                }
            }

        }


        //Paiguta laev
        for (int i = 0; i < pikkus; i++) {
            getMänguväli().setSisu(y + i * delta_x, x + i * delta_y, Väli.laev);
        }
        return true;
    }

    /**
     * Sooritab lasu mängija väljale,
     *
     * @param x
     * @param y
     * @return boolean kas sai pihta
     */
    boolean vastaseLask(int x, int y) throws JubaLastudErind {
        if (mänguväli.getSisu(x, y).equals(Väli.laev)) {
            mänguväli.setSisu(x, y, Väli.pihtas);
            mänguväli.pihtasPõhjas(-1, x, y);
            return true;
        } else if (mänguväli.getSisu(x, y).equals(Väli.tavaline)) {
            mänguväli.setSisu(x, y, Väli.möödas);
        } else if (mänguväli.getSisu(x, y).equals(Väli.möödas)) {
            throw new JubaLastudErind();
        }
        return false;
    }

    void väljastaVäliEndale() {
        mänguväli.väljastaVäli();
    }

    void väljastaVäliVastasele() {
        mänguväli.väljastaVäliVastasele();
    }

    public Väli getMänguväli() {
        return mänguväli;
    }

    public String getNimi() {
        return nimi;
    }

    abstract public void käik(Mängija vastane, Stage lava);
}