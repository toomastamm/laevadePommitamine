public class Väli {
    private String[][] mänguväli;
    private int pikkus;

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

    void väljastaVäli() {
        for (int i = 0; i < pikkus; i++) {
            for (int j = 0; j < pikkus; j++) {
                System.out.print(getSisu(j, i) + " ");
            }
            System.out.print("\n");
        }
    }

    void väljastaVäliVastasele() {
        for (int y = 0; y < pikkus; y++) {
            for (int x = 0; x < pikkus; x++) {
                if (getSisu(x, y) == laev) {
                    System.out.print(tavaline);
                } else {
                    System.out.print(getSisu(x, y) + " ");
                }
                System.out.print("\n");
            }
        }
    }

    String getSisu(int x, int y) {
        return mänguväli[y][x];
    }

    void setSisu(int x, int y, String sisu) {
        mänguväli[y][x] = sisu;
    }

    public int getPikkus() {
        return pikkus;
    }
}
