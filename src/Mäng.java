public class Mäng {
    Mängija mängija1;
    Mängija mängija2;

    public Mäng(int pikkus, String nimi1, String nimi2) {
        if (nimi1.equals("arvuti")) {
            this.mängija1 = new m_arvuti(nimi1, pikkus);
        } else {
            this.mängija1 = new m_inimene(nimi1, pikkus);
        }

        if (nimi2.equals("arvuti")) {
            this.mängija2 = new m_arvuti(nimi1, pikkus);
        } else {
            this.mängija2 = new m_inimene(nimi2, pikkus);
        }
    }

    void prindiVäljad() {
        System.out.println(String.format("%s:", mängija1.getNimi()));
        mängija1.väljastaVäliEndale();
        System.out.println(String.format("%s:", mängija2.getNimi()));
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

    public void laevadePaigutamine() {
        paigutaLaevad(mängija1);

        Print_abi.vahetaMängijat();

        paigutaLaevad(mängija2);
    }

    private void paigutaLaevad(Mängija mängija) {
        System.out.println(String.format("Mängija %s kord paigutada laevu: ", mängija.getNimi()));
        mängija.väljastaVäliEndale();
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                boolean paigutatud = false;
                do {
                    paigutatud = mängija.paigutaLaev(i);
                }
                while (!paigutatud);
                mängija.väljastaVäliEndale();
            }
        }
    }

    public void alustaMäng() {
        Print_abi.tühjenda_ekraan();

        pealoop:
        while (true) {
            boolean pihtas = false;
            do {
                pihtas = mängija1.lase(mängija2);
                if (mängija2.getMänguväli().laevuPole()) {
                    break pealoop;
                }
            }
            while (pihtas);

            pihtas = false;

            Print_abi.vahetaMängijat();

            do {
                pihtas = mängija2.lase(mängija1);
                if (mängija1.getMänguväli().laevuPole()) {
                    break pealoop;
                }
            }
            while (pihtas);

            Print_abi.vahetaMängijat();
        }

        prindiVäljad();
        if (mängija1.getMänguväli().laevuPole()) {
            System.out.println(String.format("Mängija %s võitis", mängija2.getNimi()));
        } else {
            System.out.println(String.format("Mängija %s võitis", mängija1.getNimi()));
        }
    }
}
