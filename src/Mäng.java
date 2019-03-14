public class Mäng {
    Mängija mängija1;
    Mängija mängija2;

    public Mäng(int pikkus) {
        this.mängija1 = new Mängija(pikkus);
        this.mängija2 = new Mängija(pikkus);
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
}
