package oop;

public class Skoor implements Comparable<Skoor> {
    public int käik;
    public String nimi;

    public Skoor(int käik, String nimi) {
        this.käik = käik;
        this.nimi = nimi;
    }

    @Override
    public int compareTo(Skoor s) {
        if (this.käik < s.käik) {
            return -1;
        } else if (this.käik > s.käik) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  nimi + " - " + käik;
    }
}
