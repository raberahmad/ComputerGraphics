public class ColorConverter {
    public void RGBtoHSL(int R, int G, int B){
        double r = R / 255.0;
        double g = G / 255.0;
        double b = B / 255.0;

        double Cmax;
        double Cmin;

        if ((r > g) && (b < g) ){
            Cmax = r;
            Cmin = b;

            double H = (g - Cmin)/(Cmax - Cmin)*60.0;
            System.out.println(H);
        }
        if ((r < g) && (b < r) ){
            Cmax = g;
            Cmin = b;

            double H = (Cmax - r)/(Cmax-Cmin)*60.0+60.0;
            System.out.println(H);
        }
        else {
            System.out.println("error");
        }
        
    }
}
