package Ex2;
import java.io.*;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        int number, sum = 0, count = 0, min, max;
        float average;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
            String line;
            line = reader.readLine();
            number = Integer.parseInt(line);
            min = number;
            max = number;
            count++;
            sum = sum + number;
            while(( line = reader.readLine())!=null) {
                number = Integer.parseInt(line);
                sum = sum + number;
                count++;
                if (number > max)
                    max = number;
                if (number < min)
                    min = number;
            }
            average = ((float) sum /count);
            System.out.println("Suma celor " + count + " valori este: " + sum);
            System.out.println("Minimul este: " + min);
            System.out.println("Maximul este: " + max);
            System.out.println("Media este: " + average);

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Suma celor " + count + " valori este: " + sum + "\n");
            writer.write("Minimul este: " + min + "\n");
            writer.write("Maximul este: " + max + "\n");
            writer.write("Media este: " + average + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
