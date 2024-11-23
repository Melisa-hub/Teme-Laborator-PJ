package Ex4;
import java.time.LocalDate;
import java.time.Period;

public class Persoana {
private String nume;
private String CNP;

private int varsta;

public Persoana(String nume, String CNP){
    this.nume = nume;
    this.CNP = CNP;
}
public String getNume(){
    return this.nume;
}
public String getCNP(){
    return this.CNP;
}
public int Varsta(){
    LocalDate today = LocalDate.now();
    String dataNasterii="";
    int primaCifra = Character.getNumericValue(this.CNP.charAt(0));
    if(primaCifra == 1 || primaCifra == 2)
        dataNasterii = "19" + this.CNP.charAt(1) + this.CNP.charAt(2)+'-';
    else if (primaCifra == 5 || primaCifra == 6) {
        dataNasterii = "20" + this.CNP.charAt(1) + this.CNP.charAt(2)+'-';
    }
dataNasterii = dataNasterii + this.CNP.charAt(3) + this.CNP.charAt(4)+'-';
dataNasterii = dataNasterii + this.CNP.charAt(5) + this.CNP.charAt(6);
LocalDate Data = LocalDate.parse(dataNasterii);
this.varsta = Period.between(Data, today).getYears();
    return this.varsta;
}

}
