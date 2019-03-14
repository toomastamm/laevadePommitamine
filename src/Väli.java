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
        for (int i = 0; i < mänguväli.length; i++) {
            for (int j = 0; j < mänguväli[0].length; j++) {
                System.out.print(mänguväli[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    void määraSisu(int x, int y, String sisu) {
        mänguväli[y][x] = sisu;
    }

    public int getPikkus() {
        return pikkus;
    }
}
