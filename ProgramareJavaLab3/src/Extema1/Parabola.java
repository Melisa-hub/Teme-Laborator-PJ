package Extema1;
import java.lang.Math;
import java.text.DecimalFormat;
class Parabola {
    private final int a,b,c;
    private final float varfa, varfb;


    public Parabola(int x, int y, int z) {
        super();
        this.a = x;
        this.b = y;
        this.c = z;
        this.varfa = (float) -(this.b) /this.a*2;
        this.varfb = (float) (-this.b ^ 2 + this.a * 4 * this.c) /this.a*4;
    }
    @Override
    public String toString() {
        //= a x^2 + b x + c
        return   a + "x^2 + " + b + "x + " + c;
    }

    public String mijlocSegment(int x, int y){
        DecimalFormat df = new DecimalFormat("###.##");
        return "("+df.format((this.varfa + x)/2) + "," + df.format((this.varfb + y)/2) + ")";
    }

    public double lungimeSegment(int x, int y){

        return Math.hypot((x-this.varfa) , (y-this.varfb));
    }
}
