public class m_arvuti extends Mängija {
    public m_arvuti(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(int pikkus) {
        return false;
    }

    @Override
    boolean lase(Mängija vastane) {
        return false;
    }
}
