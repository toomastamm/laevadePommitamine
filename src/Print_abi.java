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

    static void vahetaMängijat() {
        küsi("Vajuta enter, et lõpetada käik");
        tühjenda_ekraan();
        küsi("Read peidetud - Vajuta enter, et vahetada mängijat");
        tühjenda_ekraan();
    }
}
