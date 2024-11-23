package Ex1;

import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Latimea = ");
        int l = scanner.nextInt();
        System.out.println("Lungimea = ");
        int L = scanner.nextInt();
        System.out.println("\nPerimetru = " + (2 * l + 2 * L));
        System.out.println("Aria = " + (l*L));
        scanner.close();
    }
}
