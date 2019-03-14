public class Mäng {
    Mängija mängija1;
    Mängija mängija2;

    public Mäng(int pikkus, String nimi1, String nimi2) {
        this.mängija1 = new Mängija(nimi1, pikkus);
        this.mängija2 = new Mängija(nimi2, pikkus);
    }

    void prindiVäljad() {
        System.out.println("Mängija 1:");
        mängija1.prindiVäli();
        System.out.println("Mängija 2:");
        mängija2.prindiVäli();
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
