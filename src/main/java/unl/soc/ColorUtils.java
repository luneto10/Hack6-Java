package unl.soc;
/**
 * Name: Luciano Carvalho (lguedesdecarvalhon2@huskers.unl.edu)
 * <p>
 * Date: 2023 - 10 - 06
 * <p>
 * Utils methods to convert RBG to CMYK and CMYK to RGB
 */

import org.w3c.dom.css.RGBColor;

import java.util.EnumMap;

public class ColorUtils {

    /*Tranforms RGB values to CMYK values
     */
    public static CMYK rgbToCMYK(RGB color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }

        if (color.getRed() < 0 || color.getRed() > 255 || color.getGreen() < 0 || color.getGreen() > 255 ||
                color.getBlue() < 0 || color.getBlue() > 255) {
            throw new IllegalArgumentException();
        }

        double newR, newG, newB, k, c, m, y;
        newR = color.getRed() / 255.0;
        newG = color.getGreen() / 255.0;
        newB = color.getBlue() / 255.0;

        k = 1 - Math.max(Math.max(newR, newG), newB);
        c = (1 - newR - k) / (1 - k);
        m = (1 - newG - k) / (1 - k);
        y = (1 - newB - k) / (1 - k);

        if (color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
            k = 1;
            c = 0;
            m = 0;
            y = 0;
        }

        return new CMYK(c, m, y, k);
    }

    /*Tranforms CMYK values to RGB value
     */
    public static RGB cmykToRGB(CMYK color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }

        if (color.getCyan() < 0 || color.getCyan() > 1 || color.getYellow() < 0 || color.getYellow() > 1 ||
                color.getMagenta() < 0 || color.getMagenta() > 1 || color.getK() < 0 || color.getK() > 1) {

            throw new IllegalArgumentException();
        }

        int r, g, b;
        r = (int) Math.round(255 * (1 - color.getCyan()) * (1 - color.getK()));
        g = (int) Math.round(255 * (1 - color.getMagenta()) * (1 - color.getK()));
        b = (int) Math.round(255 * (1 - color.getYellow()) * (1 - color.getK()));

        return new RGB(r, g, b);
    }
}
