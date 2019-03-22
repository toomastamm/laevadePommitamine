import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sisesta esimese mängija nimi: ");
        Scanner scanner = new Scanner(System.in);
        String nimi1 = scanner.nextLine();
        System.out.println("Sisesta teise mängija nimi: ");
        String nimi2 = scanner.nextLine();

        Mäng mäng = new Mäng(10, nimi1, nimi2);

        System.out.println(mäng.toString());
        mäng.prindiVäljad();

    }
}
