public class ColorConverter {
    public void RGBtoHSL(int R, int G, int B){
        double r = R / 255.0;
        double g = G / 255.0;
        double b = B / 255.0;
        double Cmax=0.0 ;
        double Cmin=0.0;
        double H=0.0;
        double S=0.0;
        double L=0.0;

        if ((r >= g) && (b <= g) ){

            Cmax = r;
                Cmin = b;
            H = (g - Cmin)/(Cmax - Cmin)*60.0;

        }
        else if ((r <= g) && (b <= r) ){
                Cmax = g;
                Cmin = b;
            H = (Cmax - r)/(Cmax-Cmin)*60.0+60.0;
        }
        else if((g >= b) && (r <= b)){
                Cmax = g;
                Cmin= r;

            H = (b-Cmin)/(Cmax-Cmin)*60.0+120.0;
        }
        else if((b >= g) && (g >= r)){
                Cmax = b;
                Cmin = r;

            H = (Cmax - g)/(Cmax-Cmin)*60.0+180.0;

        }
        else if((b >= r) && (g <= r)){
                Cmax = b;
                Cmin = g;

            H = (r -Cmin)/(Cmax - Cmin)*60.0+240.0;

        }
        else if((r >= b) && (g <= b)){
                Cmax =r;
                Cmin = g;


            H = (Cmax - b)/(Cmax-Cmin)*60.0+300.0;
        }

        else {
            System.out.println("error");
        }

        if (r == g && g ==b){
            H=0.0;
            S=0.0;

            System.out.println("H:\tis niet gedefiniëerd");

            Cmax = r;
            Cmin=r;
        }
        else {
            System.out.println("H:\t"+H);
            S = (Cmax-Cmin)/(1.0-Math.abs((Cmin+Cmax)-1.0));
        }
        System.out.println("S:\t"+S);

        L = (Cmin + Cmax)/2.0;
        System.out.println("L:\t"+L);

        
    }
}
