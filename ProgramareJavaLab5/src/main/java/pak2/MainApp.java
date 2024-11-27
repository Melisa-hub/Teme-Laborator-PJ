package pak2;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static List<Mobilier> citire() {
        try {
            File file = new File("src/main/resources/mobilier.json");
            return new ObjectMapper().readValue(file, new TypeReference<List<Mobilier>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/mobilierout.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        List<Mobilier> mobilierr = citire();
        scriere(mobilierr);
        for(Mobilier m:mobilierr) {
            m.afisarePlaci();
            System.out.println("\nTotal placi necesare: " + m.calculPlaci() + "\n");
        }

    }
}