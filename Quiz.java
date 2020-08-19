import java.awt.geom.AffineTransform;
import java.awt.FontMetrics;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public final class Quiz extends Assessment {
    public Quiz(String name, Vector2D position, State state, Common common, int points) {
        super(name, position, state, common, points);
    }
    public final void draw(Graphics2D g2d) {
        final Font font = g2d.getFont();
        g2d.setFont(new Font("Sans Serif", 1, 14));
        final FontMetrics fontMetrics = g2d.getFontMetrics();
        final AffineTransform transform = g2d.getTransform();
        g2d.translate((int)this.position.x, (int)this.position.y);
        g2d.setPaint(new Color(150, 150, 255));
        g2d.fillPolygon(new int[] { 0, 12, -11 }, new int[] { -13, 9, 9 }, 3);
        final String name = new StringBuilder().append(this.name).toString();
        g2d.setPaint(Color.BLACK);
        g2d.drawString(name, (int)(-fontMetrics.stringWidth(name) / 2.0) + 1, 6);
        g2d.setTransform(transform);
        g2d.setFont(font);
    }
}
