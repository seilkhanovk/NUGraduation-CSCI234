import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public final class Academician extends Entity{
      private final int width;
      private final int height;
      private BufferedImage image = null;

      public Academician(String name, Vector2D position, State state, Common common, String imageName) {
          super(name, position, state, common);
          try {
            this.image = ImageIO.read(new File(imageName));
          } catch (Exception e) {
            System.out.println("Can not read image in Academician");
          }
          this.width = this.image.getWidth() / 4;
          this.height = this.image.getHeight() / 4;
      }

      public final void draw(Graphics2D g2d) {
          Font font = g2d.getFont();
          g2d.setFont(new Font("Sans Serif", 1, 14));
          FontMetrics fontMetrics = g2d.getFontMetrics();
          AffineTransform affineTransform = g2d.getTransform();
          g2d.translate((int)this.position.x, (int)this.position.y);
          g2d.drawImage(this.image, -this.width / 2, -this.height / 2, this.width, this.height, null);
          String name = this.name;
          g2d.setPaint(Color.BLACK);
          g2d.drawString(name, (int)(-fontMetrics.stringWidth(name) / 2.0D) + 1, -this.height / 2 - 2);
          name = this.state.toString();
          g2d.setPaint(Color.BLACK);
          g2d.drawString(name, (int)(-fontMetrics.stringWidth(name) / 2.0D) + 1, this.height / 2 + 12);
          g2d.setTransform(affineTransform);
          g2d.setFont(font);
      }
}
