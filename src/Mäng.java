public class Mäng {
    Mängija mängija1;
    Mängija mängija2;
    int käik = 0;

    /**
     * Otsustab, kas mängija on arvuti või inimene, edastab vastavalt mänguvälja x ja y pikkused
     *
     * @param pikkus mänguvälja x ja y pikkused
     * @param nimi1  mängija nimi
     * @param nimi2  -,,-
     */
    public Mäng(int pikkus, String nimi1, String nimi2) {
        if (nimi1.startsWith("arvuti")) {
            this.mängija1 = new m_arvuti(nimi1, pikkus);
        } else {
            this.mängija1 = new m_inimene(nimi1, pikkus);
        }

        if (nimi2.startsWith("arvuti")) {
            this.mängija2 = new m_arvuti(nimi2, pikkus);
        } else {
            this.mängija2 = new m_inimene(nimi2, pikkus);
        }
    }

    /**
     * Väljastab mõlema mängija väljad originaalsel kujul
     */
    void prindiVäljad() {
        System.out.println(String.format("%s:", mängija1.getNimi()));
        mängija1.väljastaVäliEndale();
        System.out.println(String.format("\n%s:", mängija2.getNimi()));
        mängija2.väljastaVäliEndale();
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
        if (!(mängija1.getNimi().startsWith("arvuti"))) {
            Print_abi.vahetaMängijat();
        }
        paigutaLaevad(mängija2);
    }

    /**
     * Annab käsu mängijale paigutada laev
     *
     * @param mängija objekt
     */
    private void paigutaLaevad(Mängija mängija) {
        System.out.println(String.format("Mängija %s kord paigutada laevu: ", mängija.getNimi()));
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                boolean paigutatud = false;
                do {
                    paigutatud = mängija.paigutaLaev(i);
                }
                while (!paigutatud);
            }
        }
        System.out.println("Laevad paigutatud");
    }

    /**
     * Alustab mängu põhiosa ehk pommitamist
     */
    public void alustaMäng() {
        Print_abi.tühjenda_ekraan();

        pealoop:
        while (true) {
            boolean pihtas = false;
            do {
                this.käik += 1;
                System.out.println(String.format("Käik %s", this.käik));
                pihtas = mängija1.lase(mängija2);
                if (mängija2.getMänguväli().laevuPole()) {
                    break pealoop;
                }
            }
            while (pihtas);

            pihtas = false;

            do {
                this.käik += 1;
                System.out.println(String.format("Käik %s", this.käik));
                pihtas = mängija2.lase(mängija1);
                if (mängija1.getMänguväli().laevuPole()) {
                    break pealoop;
                }
            }
            while (pihtas);

        }

        prindiVäljad();
        if (mängija1.getMänguväli().laevuPole()) {
            System.out.println(String.format("Mängija %s võitis", mängija2.getNimi()));
        } else {
            System.out.println(String.format("Mängija %s võitis", mängija1.getNimi()));
        }
    }
}
