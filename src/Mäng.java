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
        System.out.println(String.format("Mängija %s kord paigutada laevu: ", mängija1.getNimi()));
        mängija1.väljastaVäliEndale();
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 5-i; j++) {
                boolean paigutatud = false;
                do {
                    System.out.println(String.format("Paiguta laev pikkusega %s", i));
                    paigutatud = mängija1.paigutaLaev(i);
                }
                while (!paigutatud);
                mängija1.väljastaVäliEndale();
            }
        }

        Print_abi.vahetaMängijat();

        System.out.println(String.format("Mängija %s kord paigutada laevu: ", mängija2.getNimi()));
        mängija2.väljastaVäliEndale();
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 5-i; j++) {
                boolean paigutatud = false;
                do {
                    System.out.println(String.format("Paiguta laev pikkusega %s", i));
                    paigutatud = mängija2.paigutaLaev(i);
                }
                while (!paigutatud);
                mängija2.väljastaVäliEndale();
            }
        }
    }
}
