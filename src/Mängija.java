public class Mängija {
    private Väli mänguväli;
    private String nimi;

    public Mängija(String nimi, int pikkus) {
        this.mänguväli = new Väli(pikkus);
        this.nimi = nimi;
    }


    boolean paiguaLaev(String suund, int pikkus, int x, int y) {
        int delta_x = 0;
        int delta_y = 0;
        if (suund == "alla") {
            delta_y = 1;
            if (y + pikkus > mänguväli.getPikkus()) {
                return false;
            }
        } else if (suund == "paremale") {
            delta_x = 1;
            if (x + pikkus > mänguväli.getPikkus()) {
                return false;
            }
        }

        for (int i = 0; i < pikkus; i++) {
            mänguväli.setSisu(x + i * delta_x, y + i * delta_y, Väli.laev);
        }
        return true;
    }

    void prindiVäli() {
        mänguväli.väljastaVäli();
    }

    boolean lask(int x, int y) {
        if (mänguväli.getSisu(x, y) == mänguväli.laev) {
            mänguväli.setSisu(x, y, mänguväli.pihtas);
            return true;
        } else if (mänguväli.getSisu(x, y) == mänguväli.tavaline) {
            mänguväli.setSisu(x, y, mänguväli.möödas);
        }
        return false;
    }

    public String getNimi() {
        return nimi;
    }
}