public class App {
    public static void main(String[] args) {
        ColorConverter converter = new ColorConverter();
        try {
          converter.RGBtoHSL(120, 30, 15);
          converter.HSLtoRGB(100.0, 0.0, 1);
          converter.RGBtoCMY(130,15,45);
          converter.CMYtoRGB(0.3, 0.4,0.5);
          converter.transparency(130,140,160,0.5,100,50,60);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
