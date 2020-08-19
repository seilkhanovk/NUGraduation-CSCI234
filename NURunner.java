import java.awt.KeyboardFocusManager;
import javax.swing.JFrame;

public class NURunner {
  public JFrame window;
  public Display display;
  public Common common;
  public static boolean trigger = false;

  private NURunner(String windowName, int windowWidth, int windowHeight, int numOfStudents) {
    this.window = new JFrame(windowName + "Kuanysh Seilkhanov");
    this.common = new Common(numOfStudents, windowWidth, windowHeight);
    this.display = new Display(this.common);
    this.window.add(this.display);
    this.window.setLocationByPlatform(true);
    this.window.setResizable(false);
    this.window.setDefaultCloseOperation(3);
    this.window.pack();
    this.window.setVisible(true);
  }

  public static void main (String args[]) {
    String windowName = "NU Graduation";
    int windowWidth = 1200;
    int windowHeight = 600;
    int numOfStudents = 10;
    NURunner nurunner = new NURunner(windowName, windowWidth, windowHeight, numOfStudents);
    while (true) {
        if (!trigger) {
          nurunner.common.stepAllEnties();
          nurunner.display.repaint();
        }
        try {
          Thread.sleep(50L);
        } catch(InterruptedException e) {
          System.out.println("Some problems occured in NURunner class");
        }
    }
  }

}
