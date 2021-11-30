import java.awt.Color;
/**
 * Turns the picture into a grayscale against the blue values
 * 
 * @author Kenny Castro-Monroy
 * @version 2021.11.29
 */
public class WarholFilter extends Filter
{
    /**
     * Create a new filter with a given name.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
    {
        super(name);
    }
    
    
    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image) {
        // create new image with quarter size
        int width = image.getWidth() / 2;
        int height = image.getHeight() / 2;
        OFImage small = new OFImage(width, height);

        // Create small image
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                small.setPixel(x, y, image.getPixel(x * 2, y * 2));
            }
        }

        OFImage red = new OFImage(width, height);
        OFImage green = new OFImage(width, height);
        OFImage blue = new OFImage(width, height);

        // Create Red tint quarter
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = small.getPixel(x, y);
                int r = color.getRed();
                red.setPixel(x, y, new Color(r, 0, 0));
            }
        }

        // Create Green tint quarter
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = small.getPixel(x, y);
                int g = color.getGreen();
                green.setPixel(x, y, new Color(0, g, 0));
            }
        }

        // Create Blue tint quarter
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = small.getPixel(x, y);
                int b = color.getRed();
                blue.setPixel(x, y, new Color(0, 0, b));
            }
        }

        // Place in small quarter
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setPixel(x, y, small.getPixel(x, y));
            }
        }

        // Place in red quarter(top-right)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setPixel(x + width, y, red.getPixel(x, y));
            }
        }

        // Place in green quarter(bottom-left)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setPixel(x, y + height, green.getPixel(x, y));
            }
        }

        // Place in blue quarter(bottom-right)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setPixel(x + width, y + height, blue.getPixel(x, y));
            }
        }

        // flipVerticalImage(image);
    }
}