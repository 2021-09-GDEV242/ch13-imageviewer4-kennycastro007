import java.awt.Color;
/**
 * Tints the image blue
 * 
 * @author Kenny Castro-Monroy
 * @version 2021.11.29
 */
public class BlueTintFilter extends Filter
{
    /**
     * Create a new filter with a given name.
     * @param name The name of the filter.
     */
    public BlueTintFilter(String name)
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
                int blue = color.getBlue();
                image.setPixel(x, y, new Color(0, 0, blue));
            }
        }
    }
}