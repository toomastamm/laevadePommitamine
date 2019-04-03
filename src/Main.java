public class Main {

    public static void main(String[] args) {
        System.out.println("Laevade pommitamine the Game");
        System.out.println("Kui on soov mängida arvuti vastu, sisesta nimeks 'arvuti' \n");
        String nimi1 = Print_abi.küsi("Sisesta esimese mängija nimi: ");
        String nimi2 = Print_abi.küsi("Sisesta teise mängija nimi: ");

        Mäng mäng = new Mäng(10, nimi1, nimi2);

        System.out.println(mäng.toString());

        //Laevade paigutamine
        mäng.laevadePaigutamine();
        mäng.alustaMäng();

    }
}
