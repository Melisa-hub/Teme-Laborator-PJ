package Ex4;

import java.util.Random;

public class MainApp {
    public static  int getRandomNumberUsingNextInt(int min, int max) {
            Random random = new Random();
            return random.nextInt(max - min) + min;
        }

    public static void main(String[] args) {
        int a = getRandomNumberUsingNextInt(1, 30);
        System.out.println("Primul nr random: "+a);
        int b = getRandomNumberUsingNextInt(1, 30);
        System.out.println("Al doilea nr random: "+b);
        if(b>a){
            int aux = a;
            a = b;
            b = aux;
        }
        while(a!=b){
            if(a>b)
                a = a-b;
            else if (b>a) {
                b = b-a;
            }
        }
        System.out.println("Cmmdc este: " + a);
    }

}
