public class Mängija {
    private Väli mänguväli;

    public Mängija(int pikkus) {
        this.mänguväli = new Väli(pikkus);
    }


    void paiguaLaev(String suund, int pikkus, int x, int y) {
        int delta_x = 0;
        int delta_y = 0;
        if (suund == "alla") {
            delta_y = 1;
        } else if (suund == "paremale") {
            delta_x = 1;
        }

        for (int i = 0; i < pikkus; i++) {
            mänguväli.määraSisu(x + i*delta_x, y + i*delta_y, "X");
        }
    }
}