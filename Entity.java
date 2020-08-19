import java.awt.Graphics2D;

public abstract class Entity{
    public String name;
    public Vector2D position;
    public State state;
    public Common common;

    public Entity(String name, Vector2D position, State state, Common common){
      this.name = name;
      this.position = position;
      this.state = state;
      this.common = common;
    }

    public abstract void draw (Graphics2D g2d);

    public final void step() {this.state.step(this);}
}
