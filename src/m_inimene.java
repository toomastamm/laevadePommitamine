public class m_inimene extends Mängija {

    public m_inimene(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    /**
     * Küsib kasutajalt kordinaate ja suunda, et paigutada laev
     * @param pikkus kui pikk on laev, mida paigutada
     * @return boolean kas sai paigutatud
     */
    @Override
    boolean paigutaLaev(int pikkus) {
        väljastaVäliEndale();
        System.out.println(String.format("Paiguta laev pikkusega %s", pikkus));

        int y = Integer.parseInt(Print_abi.küsi("Sisesta veerg: "));
        int x = Integer.parseInt(Print_abi.küsi("Sisesta rida: "));
        String suund = Print_abi.küsi("Sisesta suund (alla/paremale): ");

        boolean paigutus = prooviPaigutada(x, y, pikkus, suund);

        if (!paigutus) {
            System.out.println("Paigutamine ebaõnnestus!");
        }

        return paigutus;
    }

    /**
     * Küsib kasutajalt sisendit, kuhu lasta
     * @param vastane vastase mängija objekt, kuhu lasta
     * @return boolean kas sai pihta
     */
    @Override
    boolean lase(Mängija vastane) {
        vastane.väljastaVäliVastasele();
        System.out.println(String.format("%s kord lasta", getNimi()));
        int y = Integer.parseInt(Print_abi.küsi("Sisesta veerg: "));
        int x = Integer.parseInt(Print_abi.küsi("Sisesta rida: "));

        return vastane.vastaseLask(y, x);
    }
}
