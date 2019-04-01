public class m_inimene extends Mängija {

    public m_inimene(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(int pikkus) {
        int y = Integer.parseInt(Print_abi.küsi("Sisesta veerg: "));
        int x = Integer.parseInt(Print_abi.küsi("Sisesta rida: "));
        String suund = Print_abi.küsi("Sisesta suund (alla/paremale): ");
        int delta_x = 0;
        int delta_y = 0;

        //Määra suund abimuutujasse, kontrolli kas laeva jaoks on ruumi
        if (suund.equals("alla")) {
            delta_y = 1;

            //Kas mahub ära
            if (x + pikkus > getMänguväli().getPikkus()) {
                return false;
            }

            //Kas on laev 1 ruudu läheduses
            //Kas on paremal
            if (y + 1 < getMänguväli().getPikkus()) { //Kas veerg on olemas
                for (int i = 0; i < pikkus + 2; i++) {
                    if (!(getMänguväli().getSisu(y + 1, x + i * delta_y - 1).equals(Väli.tavaline)
                            || getMänguväli().getSisu(y + 1, x + i * delta_y - 1).equals("Viga"))) {
                        return false;
                    }
                }
            }

            //Kas on vasakul
            if (y - 1 >= 0) { //Kas veerg on olemas
                for (int i = 0; i < pikkus + 2; i++) {
                    //Kas veerus on juba midagi
                    if (!(getMänguväli().getSisu(y - 1, x + i * delta_y - 1).equals(Väli.tavaline)
                            || getMänguväli().getSisu(y - 1, x + i * delta_y - 1).equals("Viga"))) {
                        return false;
                    }
                }
            }

            //Kas on samal real
            for (int i = 0; i < pikkus + 2; i++) {
                if (!(getMänguväli().getSisu(y, x + (i * delta_y) - 1).equals(Väli.tavaline)
                        || getMänguväli().getSisu(y, x + (i * delta_y) - 1).equals("Viga"))) {
                    return false;
                }
            }

        } else if (suund.equals("paremale")) {
            delta_x = 1;

            //Kas mahub ära
            if (y + pikkus > getMänguväli().getPikkus()) {
                return false;
            }

            //Kas on laev 1 ruudu läheduses
            //Kas on üleval
            if (x + 1 < getMänguväli().getPikkus()) { //Kas rida on olemas
                for (int i = 0; i < pikkus; i++) {
                    //Kas reas on juba midagi
                    if (!(getMänguväli().getSisu(y + (i * delta_x) - 1, x - 1).equals(Väli.tavaline)
                            || getMänguväli().getSisu(y + (i * delta_x) - 1, x - 1).equals("Viga"))) {
                        return false;
                    }
                }
            }

            //Kas on all
            if (x - 1 >= 0) { //Kas rida on olemas
                for (int i = 0; i < pikkus; i++) {
                    //Kas reas on juba midagi
                    if (!(getMänguväli().getSisu(y + (i * delta_x) - 1, x + 1).equals(Väli.tavaline)
                            || getMänguväli().getSisu(y + (i * delta_x) - 1, x + 1 ).equals("Viga"))) {
                        return false;
                    }
                }
            }

            //Kas on samal real
            for (int i = 0; i < pikkus + 2; i++) {
                if (!(getMänguväli().getSisu(y + (i * delta_x) - 1, x).equals(Väli.tavaline)
                        || getMänguväli().getSisu(y + (i * delta_x) - 1, x).equals("Viga"))) {
                    return false;
                }
            }

        }


        //Paiguta laev
        for (int i = 0; i < pikkus; i++) {
            getMänguväli().setSisu(y + i * delta_x, x + i * delta_y, Väli.laev);
        }
        return true;
    }

    @Override
    boolean lase(Mängija vastane) {
        return false;
    }
}
