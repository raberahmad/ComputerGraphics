public class ColorConverter {
    /*
    Raber Ahmad 0921954 TI2A
    Voor de opdracht van HSL naar RGB heb ik niet gebruik gemaakt van de formule die op natschool stond. Ik heb gebruik gemaakt van een ander formule die ik
    op internet had gevonden :
    https://math.stackexchange.com/questions/288237/hsl-to-rgb-conversion

    Die van RGB naar HSL heb ik wel gewoon gebruikt gemaakt van de formule in het pdf bestand op natschool
    */
    public void RGBtoHSL(int R, int G, int B) throws Exception{
        if (R > 255 || R < 0 || G > 255 || G < 0 || B > 255 || B < 0 ){
            throw new Exception("U kunt alleen waardes van 0 tot 255 invoeren");
        }
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

        System.out.println("RGB naar HSL:");
        if (r == g && g ==b){
            H=0.0;
            S=0.0;
            Cmax = r;
            Cmin= r;

            System.out.println("H:\tis niet gedefiniëerd");
        }
        else {
            System.out.println("H:\t"+H+"\u00b0");
            S = (Cmax-Cmin)/(1.0-Math.abs((Cmin+Cmax)-1.0));
        }

        L = (Cmin + Cmax)/2.0;

        System.out.println("S:\t"+S+"\tof in procenten "+S*100.0+"%");
        System.out.println("L:\t"+L+"\tof in procenten "+L*100.0+"%");
    }

    public void RGBtoCMY(int R,int G,int B) throws Exception{
        if (R > 255 || R < 0 || G > 255 || G < 0 || B > 255 || B < 0 ){
            throw new Exception("U kunt alleen waardes van 0 tot 255 invoeren");
        }
        double r = R / 255.0;
        double g = G / 255.0;
        double b = B / 255.0;

        double C = 1 - r;
        double M = 1 - g;
        double Y = 1 - b;

        System.out.println("RGB naar CMY:");
        System.out.println("C:\t"+C+"\tafgerond: "+String.format("%.2f",C));
        System.out.println("M:\t"+M+"\tafgerond: "+String.format("%.2f",M));
        System.out.println("Y:\t"+Y+"\tafgerond: "+String.format("%.2f",Y));
    }

    public void CMYtoRGB(double C,double M,double Y) throws Exception{
        if (C > 1.0 || C < 0.0 || M > 1.0 || M < 0.0 || Y > 1.0 || Y < 0.0 ){
            throw new Exception("U kunt alleen waardes van 0 tot 1 invoeren");
        }
        double c = C;
        double m = M;
        double y = Y;

        double R = (1 - c) * 255;
        double G = (1 - m) * 255;
        double B = (1 - y) * 255;

        System.out.println("CMY naar RGB:");
        System.out.println("R:\t"+R+"\tafgerond: "+String.format("%.0f",R));
        System.out.println("G:\t"+G+"\tafgerond: "+String.format("%.0f",G));
        System.out.println("B:\t"+B+"\tafgerond: "+String.format("%.0f",B));
    }

    public void HSLtoRGB(double H, double S, double L) throws Exception{
        if (H > 360 || H < 0 || S > 1.0 || S < 0 || L > 1.0 || L < 0){
            throw new Exception("U kunt alleen waardes in graden van 0 tot 360 invullen voor H en waardes van 0 tot en met 1 voor S en L");
        }

        double r1 = 0.0;
        double g1 = 0.0;
        double b1 = 0.0;
        double R;
        double G;
        double B;
        double h = H;
        double s = S;
        double l = L;

        double C = (1.0-Math.abs(2.0*l-1.0))*s;
        double HAccent = h/60.0;
        double X = C*(1.0-Math.abs((HAccent % 2.0) -1.0));

        if(1.0 > HAccent && HAccent >=0.0 ){
            r1 = C;
            g1 = X;
            b1 = 0.0;
        }
        else if (1.0 <= HAccent && HAccent <2.0){
            r1 = X;
            g1 = C;
            b1 = 0.0;
        }
        else if (2.0 <= HAccent && HAccent <3.0){
            r1 = 0.0;
            g1 = C;
            b1 = X;
        }
        else if (3.0 <= HAccent && HAccent <4.0){
            r1 = 0.0;
            g1 = X;
            b1 = C;
        }
        else if (4.0 <= HAccent && HAccent <5.0){
            r1 = X;
            g1 = 0.0;
            b1 = C;
        }
        else if (5.0 <= HAccent && HAccent <6.0){
            r1 = C;
            g1 = 0;
            b1 = X;
        }

        double m = l - (C*0.5);

        R = (r1+m) * 255;
        G = (g1 + m) * 255;
        B = (b1 + m) * 255;
        System.out.println("HSL naar RGB:");
        System.out.println("R:\t"+R+"\tafgerond: "+String.format("%.0f",R));
        System.out.println("G:\t"+G+"\tafgerond: "+String.format("%.0f",G));
        System.out.println("B:\t"+B+"\tafgerond: "+String.format("%.0f",B));
    }

    public void transparency(int R1,int G1,int B1,double alpha1,int R2,int G2,int B2) throws Exception{
        if (R1 > 255 || R1 < 0 || G1 > 255 || G1 < 0 || B1 > 255 || B1 < 0 || alpha1 > 1.0 ||
          alpha1 < 0 || R2 > 255 || R2 < 0 || G2 > 255 || G2 < 0 || B2 > 255 || B2 < 0 ){
            throw new Exception("U kunt alleen RGB waardes van 0 tot en met 255 invoeren en waardes van 0 tot en met 1 voor alpha");
        }

        double r1 = R1/255.0;
        double g1 = G1/255.0;
        double b1 = B1/255.0;

        double r2 = R2/255.0;
        double g2 = R2/255.0;
        double b2 = R2/255.0;

        Double R = ((alpha1 * r1) + ((1.0-alpha1)*r2))*255;
        Double G = ((alpha1 * g1) + ((1.0-alpha1)*g2))*255;
        Double B = ((alpha1 * b1) + ((1.0-alpha1)*r2))*255;

        System.out.println("Eind kleur tranparantie:");
        System.out.println("R:\t"+R+"\tafgerond: "+String.format("%.0f",R));
        System.out.println("G:\t"+G+"\tafgerond: "+String.format("%.0f",G));
        System.out.println("B:\t"+B+"\tafgerond: "+String.format("%.0f",B));
    }
}