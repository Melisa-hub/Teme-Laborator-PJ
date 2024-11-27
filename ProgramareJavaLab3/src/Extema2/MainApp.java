package Extema2;
import Extema2.Produs;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("produse.csv"));
            List<Produs> produse = new ArrayList<Produs>();
            String line;
            while((line = reader.readLine())!=null){
            String[] contentsInLine = line.split(", ");
            Produs produs = new Produs(contentsInLine[0], Float.parseFloat(contentsInLine[1]), Integer.parseInt(contentsInLine[2]), LocalDate.parse(contentsInLine[3]));
            produse.add(produs);

            }

            String optiune;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nMeniu");
                System.out.println("a)Afisare Produse");
                System.out.println("b)Afisare Produse expirate");
                System.out.println("c)Vanzare produse");
                System.out.println("d)Afisarea produselor cu prețul minim");
                System.out.println("e)Salvarea produselor care au o cantitate mai mica decat o valoare citita de la tastatura intr-un fisier de iesire.");
                System.out.println("f)Iesire");
                System.out.println("g)Eliminare produse duplicate.");
                System.out.println("Introduceti optiunea dvs: ");
                optiune = scanner.next();
                switch(optiune){
                    case "a" -> {

                        System.out.println("Produse: ");
                        for(Produs prod: produse){
                            System.out.println(prod);
                        }
                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    case "b" -> {
                        LocalDate currentDate = LocalDate.now();
                        System.out.println("\nProduse expirate: ");
                        for(Produs prod: produse){
                            if(currentDate.isAfter(prod.getDataExpirarii()))
                                System.out.println(prod);
                        }
                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    case "c" -> {

                        String numeProdus;
                        int cantitate;
                        System.out.println("Introduceti numele produsului: ");
                        numeProdus = scanner.next();
                        for(Produs prod: produse)
                        {
                            if(prod.getNume().equals(numeProdus))
                            {
                                System.out.println("Introduceti cantitatea dorita: ");
                                do{
                                    cantitate = scanner.nextInt();
                                }while(prod.getCantitate()<cantitate);
                                prod.buy(cantitate);

                            }

                            }
                        for(int i = 0; i<produse.size();i++){
                            if(produse.get(i).getCantitate()==0)
                                produse.remove(i);

                        }
                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    case "d" -> {
                        float pretMinim = produse.get(0).getPret();
                        for(Produs prod: produse){
                            if(prod.getPret()<pretMinim)
                                pretMinim = prod.getPret();
                        }
                        for(Produs prod: produse){
                            if(prod.getPret() == pretMinim)
                                System.out.println(prod);}
                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    case "e" -> {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
                        System.out.println("Introduceti pretul: ");
                        int pret = scanner.nextInt();
                        for(Produs prod: produse){
                            if(prod.getCantitate()<pret)
                                writer.write(prod.getNume() + " " +  prod.getPret() + " " + prod.getCantitate() + " " + prod.getDataExpirarii() + "\n");
                        }
                        writer.close();
                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    case "f" -> {
                        System.out.println("Incasari: "+Produs.getIncasari());
                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    case "g" ->{

                        for(int i=0;i<produse.size()-1;i++){
                            for(int j =i+1; j<produse.size();j++)
                                if(produse.get(i).getNume().equals(produse.get(j).getNume()))
                                {
                                    produse.get(i).addCantitate(produse.get(j).getCantitate());
                                    produse.remove(produse.get(j));
                                }

                        }

                        System.out.println("Press Enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + optiune);
                }
            }while (!optiune.equals("f"));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
