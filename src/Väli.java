public class Väli {
    private static String[][] mänguväli;
    private static int pikkus;

    // Välja tähisd
    static String tavaline = "○";
    static String pihtas = "X";
    static String möödas = "M";
    static String pihtasPõhjas = "P";
    static String laev = "L";

    public Väli(int pikkus) {
        this.pikkus = pikkus;
        this.mänguväli = new String[pikkus][pikkus];

        for (int i = 0; i < mänguväli.length; i++) {
            for (int j = 0; j < mänguväli[0].length; j++) {
                mänguväli[i][j] = Väli.tavaline;
            }
        }
    }

    /**
     * Väljastab mänguvälja konsooli originaalsel kujul
     */
    void väljastaVäli() {
        for (int i = 0; i < pikkus; i++) {
            for (int j = 0; j < pikkus; j++) {
                System.out.print(getSisu(j, i) + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Väljastab mänguvälja konsooli, peites ära laevad
     */
    void väljastaVäliVastasele() {
        for (int y = 0; y < pikkus; y++) {
            for (int x = 0; x < pikkus; x++) {
                if (getSisu(x, y).equals(laev)) {
                    System.out.print(tavaline + " ");
                } else {
                    System.out.print(getSisu(x, y) + " ");
                }
            }
            System.out.print("\n");
        }
    }


    /**
     * Tagastab mänguvälja x, y kordinaadil asuva väärtuse
     *
     * @param x
     * @param y
     * @return
     */
    static String getSisu(int x, int y) {
        if (x >= 0 && x < getPikkus() && y >= 0 && y < getPikkus()) {
            return mänguväli[y][x];
        }
        return "Viga";
    }


    /**
     * Määrab mänguvälja x, y kordinaadi sisu ümber
     *
     * @param x
     * @param y
     * @param sisu
     */
    void setSisu(int x, int y, String sisu) {
        mänguväli[y][x] = sisu;
    }

    /**
     * Tagastab mänguvälja külgede pikkuse
     *
     * @return
     */
    public static int getPikkus() {
        return pikkus;
    }

    /**
     * Vaatab rekursiivselt, kas laev on põhja lastud, kui on, siis muudab laeva pihtasPõhjaks
     *
     * @param suund -1 = Määramata
     *              1 = Üles
     *              2 = Paremale
     *              3 = Alla
     *              4 = Vasakule
     * @param x
     * @param y
     */
    public boolean pihtasPõhjas(int suund, int x, int y) {
        if (kordinaadidOlemas(x, y)) {  //Kordinaatid olemas
            if (getSisu(x, y).equals(laev)) { //Kas on laev
                return false;
            } else if (!getSisu(x, y).equals(pihtas)) {
                //Kui ei ole laev ja ei ole pihtas, siis on midagi muud ning pole vaja edasi minna, selles suunas laev põhjas
                return true;
            }
        } else {
            //Kui kordinaate pole, on selles suunas laev põhjas
            return true;
        }

        if (suund == -1) {
            boolean a = pihtasPõhjas(1, x, y - 1);  //Üles
            boolean b = pihtasPõhjas(2, x + 1, y);  //Paremale
            boolean c = pihtasPõhjas(3, x, y + 1);  //Alla
            boolean d = pihtasPõhjas(4, x - 1, y);  //Vasakule

            if (a && b && c && d) {
                muudaLaevPõhjas(-1, x, y);  //Kui igas suunas on laev pihtas, siis muudame kõik pihtas pihtasPõhjaks
            }
            return false;
        } else if (suund == 1) {
            return pihtasPõhjas(1, x, y - 1);  //Üles
        } else if (suund == 2) {
            return pihtasPõhjas(2, x + 1, y);  //Paremale
        } else if (suund == 3) {
            return pihtasPõhjas(3, x, y + 1);  //Alla
        } else if (suund == 4) {
            return pihtasPõhjas(4, x - 1, y);  //Vasakule
        }
        return false; //Ei tohiks siiamaani jõuda
    }

    /**
     * Muudab rekursiivselt kõik algkordinaadiga ühendatud pihtas väärtused pihtas põhjaks
     *
     * @param suund -1 = Määramata
     *              1 = Üles
     *              2 = Paremale
     *              3 = Alla
     *              4 = Vasakule
     * @param x
     * @param y
     */
    public void muudaLaevPõhjas(int suund, int x, int y) {
        //Kui enam pole selles suunas pihtas, pole mõtet edasi kontrollida
        if (kordinaadidOlemas(x, y)) {
            if (!getSisu(x, y).equals(pihtas)) {
                return;
            }
        } else {
            return;
        }

        setSisu(x, y, pihtasPõhjas);

        if (suund == -1) {
            muudaLaevPõhjas(1, x, y - 1);
            muudaLaevPõhjas(2, x + 1, y);
            muudaLaevPõhjas(3, x, y + 1);
            muudaLaevPõhjas(4, x - 1, y);
        } else {
            if (suund == 1) {
                muudaLaevPõhjas(1, x, y - 1);
            } else if (suund == 2) {
                muudaLaevPõhjas(2, x + 1, y);
            } else if (suund == 3) {
                muudaLaevPõhjas(3, x, y + 1);
            } else if (suund == 4) {
                muudaLaevPõhjas(4, x - 1, y);
            }
        }
    }

    /**
     * Kontrollib, kas laevu on veel mänguväljal.
     *
     * @return
     */
    public boolean laevuPole() {
        for (int y = 0; y < pikkus; y++) {
            for (int x = 0; x < pikkus; x++) {
                if (getSisu(x, y).equals(laev)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Kontrollib, kas antud kordinaadid on mänguvälja piirides
     *
     * @param x
     * @param y
     * @return
     */
    public boolean kordinaadidOlemas(int x, int y) {
        if (x < 0 || y < 0 || x >= pikkus || y >= pikkus) {
            return false;
        }
        return true;
    }

}
