package unl.soc;

public class Demo {
    public static void main(String[] args) {
        RGB input;
        CMYK input2;
        input = new RGB(10,2,30);
        input2 = new CMYK(1,0,1,1);
        System.out.println(ColorUtils.rgbToCMYK(input));
        System.out.println(ColorUtils.cmykToRGB(input2));
    }
}
