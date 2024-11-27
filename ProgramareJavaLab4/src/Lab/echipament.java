package Lab;

enum stare{ACHIZITIONAT, VANDUT, EXPUS};

enum format{A3, A4};
enum mod{COLOR, ALBNEGRU};

enum sistem{WINDOWS, LINUX};


/**
 * Clasa baza echipament
 * @author Alin Ferestyan
 * @version 1
 * @since 2023
 */
public class echipament {
private String denumire;
private  int nr_inv;
private float pret;

private String zona;
private stare a;
    /**
     * Constructorul clasei echipament
     * @param denumire numele echipamentului
     * @param nr numarul echipamentului
     * @param pret pretul echipamentului
     * @param zona zona din depozit A sau B
     * @param a starea echipamentului
     */
public echipament(String denumire, int nr, float pret, String zona, String a){

    this.denumire = denumire;
    this.nr_inv = nr;
    this.pret = pret;
    this.a =stare.valueOf(a.toUpperCase());
}
    /**
     *Setter pentru starea echipamentului
     */
    public void setA(String a) {
        this.a = stare.valueOf(a.toUpperCase());
    }

    /**
     *Getter care da acces la numele echipamentului
     * @return numele echipamentului
     */
    public String getDenumire() {
        return this.denumire;
    }
    /**
     *Getter care da acces la starea echipamentului
     * @return starea echipamentului
     */
    public String getA() {
        return a.toString();
    }
    /**
     *Getter care da acces la pretul echipamentului
     * @return pretul echipamentului
     */

    public float getPret() {
        return this.pret;
    }
    public String toString(){
    return this.denumire + " " + this.nr_inv + " " + this.pret + " " + this.a + " ";
    }
}
class imprimanta extends echipament{
private int ppm;
private String rezolutie;
private int p_car;
private mod m;

    public imprimanta(String denumire, int nr, float pret, String zona, String a, int ppm, String rez, int p_car, String m){
        super(denumire, nr,  pret,  zona, a);
        this.ppm = ppm;
        this.rezolutie = rez;
        this.p_car = p_car;
        this.m = mod.valueOf(m.toUpperCase());
    }

    public void setM(String Mod){

        mod[] moduri = mod.values();
        for(mod m: moduri)
            if(m.toString().equals(Mod.toUpperCase())){
                this.m = mod.valueOf(Mod.toUpperCase());
                System.out.println("Noul mod s-a actualizat cu succes!");
            }
    }
    public String toString(){

        return super.toString() + " " + this.ppm + " " + this.rezolutie + " " + this.p_car + " " + this.m;
    }
}

class copiator extends echipament{

   private int p_ton;
   private format f;

    public copiator(String denumire, int nr, float pret, String zona, String a, int p, String f) {
        super(denumire, nr, pret, zona, a);
        this.p_ton = p;
        this.f = format.valueOf(f.toUpperCase());
    }

    public void setF(String form){
        format[] formate = format.values();
        for (format f: formate)
            if(f.toString().equals(form.toUpperCase())) {
                this.f = format.valueOf(form.toUpperCase());
                System.out.println("Noul format s-a actualizat cu succes!");
            }

    }

    public String toString(){

        return super.toString() + " " + this.p_ton + " " + this.f;
    }
}
class sistem_de_calcul extends  echipament{

   private  String tip_mon;
   private float vit_proc;
   private int c_ssd;
   private sistem s;
    public sistem_de_calcul(String denumire, int nr, float pret, String zona, String a, String tip_mon, float vit_proc,int c_ssd, String s) {
        super(denumire, nr, pret, zona, a);
        this.s = sistem.valueOf(s.toUpperCase());
        this.c_ssd = c_ssd;
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
    }

    public void setS(String Sistem){

        sistem[] sisteme = sistem.values();
        for (sistem sis: sisteme)
            if (sis.toString().equals(Sistem.toUpperCase())){
                this.s = sistem.valueOf(Sistem.toUpperCase());
                System.out.println("Noul SO s-a actualizat cu succes!");

            }
    }
    public String toString(){
        return super.toString() + this.tip_mon + " " + this.vit_proc + " " + this.c_ssd + " " + this.s;

    }
}