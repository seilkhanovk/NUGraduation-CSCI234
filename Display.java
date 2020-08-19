import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Iterator;
import javax.swing.JPanel;

public final class Display extends JPanel {
  private Common common;

  public Display(Common common) {
    this.common = common;
    setBackground(Color.WHITE);
  }

  public final Dimension getPreferredSize() {
    return new Dimension(this.common.windowWidth, this.common.windowHeight);
  }

  public final void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    Common common1;
    (common1 = this.common).map.draw(g2d);
    if (common1.isAllCollected) {
      Iterator it1 = common1.speakers.iterator();
      while (it1.hasNext()) {
          Speaker speaker;
          (speaker = (Speaker)it1.next()).draw(g2d);
      }
      Font font = g2d.getFont();
      g2d.setFont(new Font("Sans Serif", 1, 14));
      FontMetrics fontMetrics = g2d.getFontMetrics();
      AffineTransform affineTransform = g2d.getTransform();
      String name = "Graduation Ceremony";
      g2d.translate((int)common1.center.x, (int)common1.center.y + 70);
      g2d.setPaint(Color.BLACK);
      g2d.drawString(name, (int)(-fontMetrics.stringWidth(name) / 2.0D), 0);
      g2d.setTransform(affineTransform);
      g2d.setFont(font);
    }else {
      Iterator it = common1.assessments.iterator();
      while (it.hasNext()) {
        Assessment assessment;
        (assessment = (Assessment)it.next()).draw(g2d);
      }
    }
    Iterator it = common1.students.iterator();
    while (it.hasNext()) {
      Student student;
      (student = (Student)it.next()).draw(g2d);
    }
    it = common1.academicians.iterator();
    while (it.hasNext()) {
      Academician academician;
      (academician = (Academician)it.next()).draw(g2d);
    }
  }
}
