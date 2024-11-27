package pak1;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PerecheNumere() {
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean suntConsecutiveInFibonacci() {
        int c;
        while (a + b <= b) {
            c = a + b;
            a = b;
            b = c;
        }
        return a + b == b;
    }
    public int celMicMultipluComun() {
        int cmmdc = cmmdc(a, b);
        return (a * b) / cmmdc;
    }
    private int cmmdc(int a, int b) {
        if (b == 0) {
            return a;
        }
        return cmmdc(b, a % b);
    }
    public boolean sumaCifrelorEgala(){
        int sum1=0;
        int sum2=0;
        while(a!=0 && b!=0)
        {
            sum1=a%10;
            a=a/10;
            sum2=b%10;
            b=b/10;
        }
        return sum1==sum2;
    }
    public boolean numarCifrePare()
    {
        int cifrePare1 = 0;
        int cifrePare2=0;
        while (a != 0 & b!=0) {
            int c1 = a % 10;
            int c2 = b % 10;
            if (c1 % 2 == 0) {
                cifrePare1++;
            }
            if(c2%10==0)
            {
                cifrePare2++;
            }
            a=a/10;
            b=b/10;
        }
        return cifrePare1==cifrePare2;
    }


}