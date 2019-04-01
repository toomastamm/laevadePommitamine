public class m_inimene extends Mängija {

    public m_inimene(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(int pikkus) {
        int y = Integer.parseInt(Print_abi.küsi("Sisesta veerg: "));
        int x = Integer.parseInt(Print_abi.küsi("Sisesta rida: "));
        String suund = Print_abi.küsi("Sisesta suund (alla/paremale): ");

        return prooviPaigutada(x, y, pikkus, suund);
    }

    @Override
    boolean lase(Mängija vastane) {
        return false;
    }
}
