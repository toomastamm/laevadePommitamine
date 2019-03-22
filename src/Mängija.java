abstract public class Mängija {
    private Väli mänguväli;
    private String nimi;

    public Mängija(String nimi, int pikkus) {
        this.mänguväli = new Väli(pikkus);
        this.nimi = nimi;
    }

    abstract boolean paigutaLaev(int pikkus);

    abstract boolean lase(Mängija vastane);

    /**
     * Sooritab lasu mängija väljale,
     * @param x
     * @param y
     * @return pihtas - true, möödas - false
     */
    boolean vastaseLask(int x, int y) {
        if (mänguväli.getSisu(x, y).equals(Väli.laev)) {
            mänguväli.setSisu(x, y, Väli.pihtas);
            return true;
        } else if (mänguväli.getSisu(x, y).equals(Väli.tavaline)) {
            mänguväli.setSisu(x, y, Väli.möödas);
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


}