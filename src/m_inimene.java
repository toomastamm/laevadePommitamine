public class m_inimene extends Mängija {

    public m_inimene(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(int pikkus) {
        int x = Integer.parseInt(Print_abi.küsi("Sisesta rida: "));
        int y = Integer.parseInt(Print_abi.küsi("Sisesta veerg: "));
        String suund = Print_abi.küsi("Sisesta suund (alla/paremale): ");
        int delta_x = 0;
        int delta_y = 0;

        //Määra suund abimuutujasse, kontrolli kas laeva jaoks on ruumi
        if (suund.equals("alla")) {
            delta_y = 1;
            if (y + pikkus > getMänguväli().getPikkus()) {
                return false;
            }
        } else if (suund.equals("paremale")) {
            delta_x = 1;
            if (x + pikkus > getMänguväli().getPikkus()) {
                return false;
            }
        }

        for (int i = 0; i < pikkus; i++) {
            getMänguväli().setSisu(x + i * delta_x, y + i * delta_y, Väli.laev);
        }
        return true;

        //Paiguta laev
        for (int i = 0; i < pikkus; i++) {
            getMänguväli().setSisu(x + i * delta_x, y + i * delta_y, Väli.laev);
        }
        return true;
    }

    @Override
    boolean lase(Mängija vastane) {
        return false;
    }
}
