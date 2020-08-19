import java.awt.geom.AffineTransform;
import java.awt.FontMetrics;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public final class Student extends Entity {
  public int grade;
  public Student(String name, Vector2D position, State state, Common common) {
      super(name, position, state, common);
  }
  public final void draw(Graphics2D g2d) {
      final Font font = g2d.getFont();
      g2d.setFont(new Font("Sans Serif", 1, 14));
      final FontMetrics fontMetrics = g2d.getFontMetrics();
      final AffineTransform transform = g2d.getTransform();
      g2d.translate((int)this.position.x, (int)this.position.y);
      if (this.grade >= 100) {
        g2d.setPaint(Color.MAGENTA);
      }else
        g2d.setPaint(Color.CYAN);
      g2d.fillOval(-15, -15, 30, 30);
      g2d.setPaint(Color.BLACK);
      g2d.drawOval(-15, -15, 30, 30);

      String name = this.name;
      g2d.setPaint(Color.BLACK);
      g2d.drawString(name, (int)(-fontMetrics.stringWidth(name) / 2.0) + 1, -18);

      String gr = new StringBuilder().append(this.grade).toString();
      g2d.setPaint(Color.BLACK);
      g2d.drawString(gr, (int)(-fontMetrics.stringWidth(gr) / 2.0) + 1, 6);

      name = this.state.toString();
      g2d.setPaint(Color.BLACK);
      g2d.drawString(name, (int)(-fontMetrics.stringWidth(name) / 2.0) + 1, 30);
      g2d.setTransform(transform);
      g2d.setFont(font);
  }
}
