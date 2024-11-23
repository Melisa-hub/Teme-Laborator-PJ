package Ex3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;
public class MainApp {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti un numar: ");
        number = scanner.nextInt();
        int numofDivs = 0;
        for(int d = 2; d*d <= number; d++){
            if(number % d == 0)
            {
                numofDivs++;
                if(d*d<number)
                    numofDivs++;
            }
        }
        if(numofDivs == 0)
            System.out.println("Numarul introdus este prim");
        else {
             System.out.println(numofDivs);
            int[] divizori = new int[numofDivs+2];
            divizori[0] = 1;
            int i = 1;
            for(int d = 2; d*d <= number; d++){
                if(number % d == 0)
                {
                    divizori[i] = d;
                    ++i;
                    if(d*d<number){
                        divizori[i] = number/d;
                        i++;
                }
            }
            }
            divizori[(divizori.length)-1] = number;
            Arrays.sort(divizori);
            System.out.println("Divizorii numarului introdus sunt: \n");
            System.out.println(Arrays.toString(divizori));
        }
        }
    }

