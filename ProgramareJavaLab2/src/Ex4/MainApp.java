package Ex4;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import Ex4.Persoana;
public class MainApp {
    public static int check(String cnp){
        char car;
    if(cnp.length()!=13)
        return 0;
    car = cnp.charAt(0);
    int j = "123456".indexOf(car);
    if(j<0)
        return 0;
    for(int i =0; i<cnp.length();i++){
        car = cnp.charAt(i);
        if(!Character.isDigit(car))
            return 0;
    int cifraControl,x, s = 0;
    String numar = "279146358279";
    int ultimaCifra = Character.getNumericValue(cnp.charAt(12));
        for( i =0; i<cnp.length()-1;i++){
            x = Character.getNumericValue(cnp.charAt(i));
            s = s + (x*(Character.getNumericValue(numar.charAt(i))));

        }
        cifraControl = s%11;
        if(cifraControl!=ultimaCifra)
            return 0;
    }

    return 1;
    }
    public static void main(String[] args) {
    int n;

    String CNP, nume;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduceti numarul de persoane: ");
    n = scanner.nextInt();
    Persoana[] pers = new Persoana[n];
    for(int i = 0; i<n; i++){

     do {
         System.out.println("Dati CNP-ul: ");
         CNP = scanner.next();
         System.out.println("Dati numele: ");
         nume = scanner.next();
         if(check(CNP)>0)
         {
             Persoana persoana = new Persoana(nume, CNP);
             pers[i] = persoana;


         }

     }while(check(CNP)==0);

    }
        for(int i =0;i<n;i++){
         System.out.println(pers[i].getCNP()+" "+ pers[i].getNume()+" "+pers[i].Varsta());

         }
    }
}
