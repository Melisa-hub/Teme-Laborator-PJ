package pak2;


import java.util.List;

public class Mobilier {
    private String nume;
    private List<Placa> placi;

    public Mobilier() {
    }

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }

    public void afisarePlaci() {
        int k = 1;
        for (Placa p : placi) {
            System.out.println("Placa " + k++ + ":" + p.toString());
        }

    }

    public int calculPlaci() {
        int arie = 0;
        int k = 1;
        System.out.println("_____");
        for (Placa p : placi) {
            arie += p.latime * p.lungime;
            System.out.println("Placa " + k++ + " arie: " + arie);
        }
        int ariePal = 2800 * 2070;
        return Math.round(arie / ariePal)+1;
    }
}