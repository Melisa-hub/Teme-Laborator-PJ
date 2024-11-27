package Extema1;
import Extema1.Parabola;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {

    List<Parabola> parabole = new ArrayList<Parabola>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
            String line;
            while(( line = reader.readLine())!=null){ //read all lines
                String[] integersInLine = line.split(" "); //split each line to get all numbers 
                int[] integers = new int[integersInLine.length]; //integers will contain all numbers from each line
                for (int i = 0; i < integersInLine.length; i++) {
                    integers[i] = Integer.parseInt(integersInLine[i]); //convert from string to int
                }
                Parabola parabola = new Parabola(integers[0], integers[1], integers[2]);
                parabole.add(parabola);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }

        DecimalFormat df = new DecimalFormat("###.##");
        for(Parabola par: parabole){
            System.out.println(par + " coordonate: " + par.mijlocSegment(1,1) + " lungime: " + df.format(par.lungimeSegment(1,1)));
        }
    }
}
