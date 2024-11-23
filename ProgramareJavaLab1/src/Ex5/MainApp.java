package Ex5;

import java.util.Random;

public class MainApp {
    public static  int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    static boolean isFibonacci(int N)
    {
        if (N == 0 || N == 1)
            return true;
        int a = 0, b = 1, c;
        while (true) {
            c = a + b;
            a = b;
            b = c;
            if (c == N)
                return true;
            else if (c >= N) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int randomNumber = getRandomNumberUsingNextInt(0,20);
        System.out.println("Numarul random generat: "+randomNumber);
        if(isFibonacci(randomNumber))
            System.out.println("Apartine sirului lui Fibonacci");
        else
            System.out.println("Nu apartine sirului lui Fibonacci");
    }
}
