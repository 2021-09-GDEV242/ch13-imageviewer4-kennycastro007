import java.awt.Color;
/**
 * Turns the picture into a grayscale against the red values
 * 
 * @author Kenny Castro-Monroy
 * @version 2021.11.29
 */
public class RedChannelFilter extends Filter
{
    /**
     * Create a new filter with a given name.
     * @param name The name of the filter.
     */
    public RedChannelFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image) {
        int height = image.getHeight();
        int width = image.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = image.getPixel(x, y);
                int red = color.getRed();
                image.setPixel(x, y, new Color(red, red, red));
            }
        }
    }
}
