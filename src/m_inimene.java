public class m_inimene extends Mängija {

    public m_inimene(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(String suund, int pikkus, int x, int y) {
        int delta_x = 0;
        int delta_y = 0;
        if (suund == "alla") {
            delta_y = 1;
            if (y + pikkus > getMänguväli().getPikkus()) {
                return false;
            }
        } else if (suund == "paremale") {
            delta_x = 1;
            if (x + pikkus > getMänguväli().getPikkus()) {
                return false;
            }
        }

        for (int i = 0; i < pikkus; i++) {
            getMänguväli().setSisu(x + i * delta_x, y + i * delta_y, Väli.laev);
        }
        return true;
    }
}
