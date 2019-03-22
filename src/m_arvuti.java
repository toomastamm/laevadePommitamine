public class m_arvuti extends Mängija {
    public m_arvuti(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(String suund, int pikkus, int x, int y) {
        return false;
    }
}
