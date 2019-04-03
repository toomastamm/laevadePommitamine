public class m_arvuti extends Mängija {
    public m_arvuti(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(int pikkus) {
        väljastaVäliEndale();
        int x;
        int y;
        String suund;
        int suuna = (int) (Math.random() * 2);
        if (suuna == 0) {
            suund = "paremale";
            y = (int) (Math.random() * (10 - pikkus));
            x = (int) (Math.random() * 10);
        } else {
            suund = "alla";
            y = (int) (Math.random() * 10);
            x = (int) (Math.random() * (10 - pikkus));

        }
        boolean paigutus = prooviPaigutada(x, y, pikkus, suund);

        if (!paigutus) {
            System.out.println("Paigutamine ebaõnnestus!");
        }

        return paigutus;
    }

    @Override
    boolean lase(Mängija vastane) {
        vastane.väljastaVäliVastasele();

        while (true) {
            int y = (int) (Math.random() * 10);
            int x = (int) (Math.random() * 10);

            if (vastane.getMänguväli().getSisu(x, y).equals(Väli.laev) || vastane.getMänguväli().getSisu(x, y).equals(Väli.tavaline)) {
                return vastane.vastaseLask(x, y);
            }

        }
    }
}

