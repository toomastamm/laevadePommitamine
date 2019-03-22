import java.util.Scanner;

public class Print_abi {

    static void tühjenda_ekraan() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    static String küsi(String küsimus) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(küsimus);
        return scanner.nextLine();
    }

}
