package Extema2;

import java.time.LocalDate;

public class Produs {
    private String nume;
    private float pret;
    private int cantitate;
    private LocalDate dataExpirarii;
    static float incasari = 0;

    public Produs(String nume, float pret, int cantitate, LocalDate dataExpirarii){
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }
    public String toString() {
        return this.nume + " " + this.pret + " " + this.cantitate + " " + this.dataExpirarii;
    }

    public LocalDate getDataExpirarii() {
        return this.dataExpirarii;
    }

    public int getCantitate() {
        return this.cantitate;
    }
    public String getNume() {
        return this.nume;
    }
    public void buy(int cantitate){
        this.cantitate = this.cantitate - cantitate;
        incasari = incasari + cantitate*this.pret;
    }

    public  void addCantitate(int cantitate){
        this.cantitate = this.cantitate + cantitate;
    }

    public static float getIncasari() {
        return incasari;
    }

    public float getPret() {
        return this.pret;
    }
}
