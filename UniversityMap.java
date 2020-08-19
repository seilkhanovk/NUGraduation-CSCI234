import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public final class UniversityMap extends Entity {
    private BufferedImage image = null;

    public UniversityMap (String name, Vector2D position, State state, Common common, String imageName) {
        super(name, position, state, common);
        try {
            this.image = ImageIO.read(new File(imageName));
        } catch(Exception e) {
          System.out.println("can not read map in UniversityMap");
        }
    }

    public final void draw(Graphics2D g2d) {
        g2d.drawImage(this.image, 0, 0, this.common.windowWidth, this.common.windowHeight, null);
    }
}
