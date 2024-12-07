package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        ApplicationContext context =new ClassPathXmlApplicationContext("beans15.xml");
        OperatiiBD operatiiBD =(OperatiiBD)context.getBean("operatiiJDBC");

        System.out.println("---Adaugare in BD---");
        operatiiBD.insert(79, "bmw", 2023, "alb", 200);
        operatiiBD.insert(689, "audi", 2007, "rosu",340);
        System.out.println("- Afisarea persoanelor din BD:" );
        List<Masina> masini = operatiiBD.getListaMasini();

        System.out.println("---Stergere masina---");
        System.out.println("Dati numarul de inmatriculoare: ");
        Scanner scanner = new Scanner(System.in);
        int nr = scanner.nextInt();
        operatiiBD.delete(nr);

        System.out.println("Dati marca: ");
       String marca = scanner.next();
       int cnt = 0;

       for(Masina m: masini)
       {
           if(m.getMarca().equals(marca))
               cnt++;

       }
       System.out.println(cnt);


       for(Masina m: masini)
       {
           if(m.getNumar_inmatriculare() == nr)
           {
               masini.remove(m);
           break;
           }

       }
        masini.forEach(System.out::println);

        System.out.println("---Cautare masina---");
        System.out.println("Dati numarul de inmatriculoare: ");
        nr  = scanner.nextInt();
        int gasit = 0;
        for(Masina m: masini)
        {
            if(m.getNumar_inmatriculare() == nr)
            { System.out.println(m);
                gasit = 1;
            }

        }
        if(gasit==0)
            System.out.println("Nu");

        int ct = 0;
        int km=100000;
        for(Masina m: masini)
        {
            if(m.getNr_kilometri() < km)
                ct++;

        }
        System.out.println(ct);

        int an=2019;
        for(Masina m: masini)
        {
            if(m.getAnul_fabricatiei() > an) {
                System.out.println(m);
            }
        }
    }
}