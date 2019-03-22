public class Mäng {
    Mängija mängija1;
    Mängija mängija2;

    public Mäng(int pikkus, String nimi1, String nimi2) {
        this.mängija1 = new m_inimene(nimi1, pikkus);
        this.mängija2 = new m_inimene(nimi2, pikkus);
    }

    void prindiVäljad() {
        System.out.println(String.format("%s:", mängija1.getNimi()));
        mängija1.väljastaVäliEndale();
        System.out.println(String.format("%s:", mängija2.getNimi()));
        mängija2.väljastaVäliEndale();
    }

    public Mängija getMängija1() {
        return mängija1;
    }

    public Mängija getMängija2() {
        return mängija2;
    }

    @Override
    public String toString() {
        return String.format("Mängivad %s ja %s.", mängija1.getNimi(), mängija2.getNimi());
    }
}
