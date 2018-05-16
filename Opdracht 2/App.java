public class App {
    public static void main(String[] args) {
        ColorConverter converter = new ColorConverter();
        try {
          converter.HSLtoRGB(0.0, 0.0, 1);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
