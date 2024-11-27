package Lab;
import Lab.echipament;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAPP {

    public static void main(String[] args) throws IOException {
        String optiune;
        List<echipament> echipamente = new ArrayList<echipament>();
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("echipamente.csv"));
        String line, Stare ;


        while (((line= reader.readLine())!=null)){
            String[] contentsInLine = line.split(",");
            if(contentsInLine[5].equals("imprimanta")){

                imprimanta im = new imprimanta(contentsInLine[0], Integer.parseInt(contentsInLine[1]), Float.parseFloat(contentsInLine[2]), contentsInLine[3], contentsInLine[4], Integer.parseInt(contentsInLine[6]), contentsInLine[7], Integer.parseInt(contentsInLine[8]), contentsInLine[9]);
                echipamente.add(im);

            } else if (contentsInLine[5].equals("copiator")) {

                copiator co = new copiator(contentsInLine[0], Integer.parseInt(contentsInLine[1]), Float.parseFloat(contentsInLine[2]), contentsInLine[3], contentsInLine[4],  Integer.parseInt(contentsInLine[6]), contentsInLine[7]);
                echipamente.add(co);
            } else if (contentsInLine[5].equals("sistem de calcul")) {

                sistem_de_calcul si = new sistem_de_calcul(contentsInLine[0], Integer.parseInt(contentsInLine[1]), Float.parseFloat(contentsInLine[2]), contentsInLine[3], contentsInLine[4],  contentsInLine[6], Float.parseFloat(contentsInLine[7]), Integer.parseInt(contentsInLine[8]), contentsInLine[9]);
                echipamente.add(si);
            }


        }
        do {
            System.out.println("\nMeniu");
            System.out.println("a)Afişarea tuturor echipamentelor");
            System.out.println("b)Afişarea imprimantelor");
            System.out.println("c)Afişarea copiatoarelor");
            System.out.println("d)Afişarea sistemelor de calcul");
            System.out.println("e)Modificarea stării în care se află un echipament");
            System.out.println("f)Setarea unui anumit mod de scriere pentru o imprimantă\n");
            System.out.println("g)Setarea unui format de copiere pentru copiatoare ");
            System.out.println("h)Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("i)Afişarea echipamentelor vândute");
            System.out.println("j)Să se realizeze două metode statice pentru serializarea / deserializarea colecției de obiecte în fișierul echip.bin ");
            System.out.println("Introduceti optiunea dvs: ");
            optiune = scanner.next();
            switch(optiune){
                case "a" -> {
                    for(echipament e: echipamente){
                        System.out.println(e);
                    }
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "b" -> {
                    for(echipament e: echipamente){
                        if(e instanceof imprimanta)
                            System.out.println(e);


                    }
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "c" -> {
                    for(echipament e: echipamente){
                        if(e instanceof copiator)
                            System.out.println(e);
                    }
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "d" -> {
                    for(echipament e: echipamente){
                        if(e instanceof sistem_de_calcul)
                            System.out.println(e);
                    }
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "e" -> {
                    String nume = scanner.nextLine();
                    nume = scanner.nextLine();
                    stare[] stari = stare.values();
                    for(stare s: stari){
                        System.out.println(s);
                    }
                    Stare = scanner.next();
                    for(echipament e: echipamente){
                        if(e.getDenumire().equals(nume))
                            e.setA(Stare);
                    }

                }
                case "f" -> {
                    System.out.println("Introduceti numele imprimantei: ");
                    String nume_imprimanta = scanner.nextLine();
                    nume_imprimanta = scanner.nextLine();
                    mod[] moduri = mod.values();
                    for(mod m: moduri)
                        System.out.println(m);
                    System.out.println("Introduceti noul mod: ");
                    String Mod = scanner.next();
                    for(echipament e: echipamente){
                        if(e instanceof imprimanta)
                            if(e.getDenumire().equals(nume_imprimanta))
                                ((imprimanta) e).setM(Mod);
                    }

                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "g" ->{
                    System.out.println("Introduceti numele copiatorului: ");
                    String nume_copiator = scanner.nextLine();
                    nume_copiator = scanner.nextLine();
                    System.out.println("Introduceti numele formatului: ");
                    format[] formate = format.values();
                    for(format f: formate)
                        System.out.println(f);
                    String form = scanner.next();
                    for(echipament e: echipamente)
                        if (e instanceof copiator)
                            if (e.getDenumire().equals(nume_copiator))
                                ((copiator) e).setF(form);
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "h" ->{
                    System.out.println("Introduceti numele sistemului: ");
                    String nume_sistem = scanner.nextLine();
                    nume_sistem = scanner.nextLine();
                    System.out.println("Introduceti numele formatului: ");
                    sistem[] sisteme = sistem.values();
                    for(sistem s: sisteme)
                        System.out.println(s);
                    String sis = scanner.next();
                    for(echipament e: echipamente)
                        if (e instanceof sistem_de_calcul)
                            if (e.getDenumire().equals(nume_sistem))
                                ((sistem_de_calcul) e).setS(sis);
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "i" ->{
                    System.out.println("Echipamente vandute: ");
                    for (echipament e: echipamente)
                        if(e.getA().equals("vandut".toUpperCase()))
                            System.out.println(e);
                    System.out.println("Press Enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                case "j" ->{
                    System.out.println("Press Enter to exit");
                    try{System.in.read();}
                    catch(Exception e){}
                }
                default -> throw new IllegalStateException("Unexpected value: " + optiune);
            }

    }while(!optiune.equals("j"));
    }
}