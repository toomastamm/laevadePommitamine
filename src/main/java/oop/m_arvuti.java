package oop;

import javafx.stage.Stage;

public class m_arvuti extends Mängija {
    public m_arvuti(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    /**
     * Arvuti paigutab automaatselt suvalistele kordinaatidele suvalise suunaga laeva
     * @param pikkus laeva pikkus
     * @return boolean kas sai paigutatud
     */
    @Override
    void paigutaLaev(int pikkus) {
        int x;
        int y;
        boolean suund;
        int suuna = (int) (Math.random() * 2);
        if (suuna == 0) {
            suund = false;
            y = (int) (Math.random() * (10 - pikkus));
            x = (int) (Math.random() * 10);
        } else {
            suund = true;
            y = (int) (Math.random() * 10);
            x = (int) (Math.random() * (10 - pikkus));

        }
        boolean paigutus = prooviPaigutada(x, y, pikkus, suund);
    }

    @Override
    public void käik(Mängija vastane, Stage lava) {
        boolean pihtas = false;
        do {
            int y = (int) (Math.random() * 10);
            int x = (int) (Math.random() * 10);
            if (vastane.getMänguväli().getSisu(x, y).equals(Väli.laev) || vastane.getMänguväli().getSisu(x, y).equals(Väli.tavaline)) {
                try {
                    pihtas = vastane.vastaseLask(x, y);
                    if (vastane.getMänguväli().laevuPole()) {
                        break;
                    }
                } catch (JubaLastudErind e) {
                    pihtas = true;
                }
            }
        } while (pihtas);
    }
}

