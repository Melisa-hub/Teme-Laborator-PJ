package org.example;

public class Masina {
    private int numar_inmatriculare;
    private String marca;
    private int anul_fabricatiei;
    private String culoare;
    private int nr_kilometri;

    public Masina(int numar_inmatriculare, String marca, int al_fabricatiei, String culoare,int r_kilometri) {
        this.numar_inmatriculare = numar_inmatriculare;
        this.marca = marca;
        this.anul_fabricatiei=al_fabricatiei;
        this.culoare = culoare;
        this.nr_kilometri = r_kilometri;
    }

    public Masina(){}

    public int getNumar_inmatriculare() {
        return numar_inmatriculare;
    }

    public void setNumar_inmatriculare(int numar_inmatriculare) {
        this.numar_inmatriculare = numar_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnul_fabricatiei() {return anul_fabricatiei;}


    public void setAnul_fabricatiei(int anul_fabricatiei) {
        this.anul_fabricatiei = anul_fabricatiei;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNr_kilometri() {
        return nr_kilometri;
    }
    public void setNr_kilometri(int nr_kilometri) {
        this.nr_kilometri = nr_kilometri;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "numar_inmatriculare=" + numar_inmatriculare +
                ", marca='" + marca + '\'' +
                ", anul_fabricatiei='" + anul_fabricatiei + '\'' +
                ", culoare='" + culoare + '\'' +
                ", nr_kilometri='" + nr_kilometri + '\'' +
                '}';
    }
}
