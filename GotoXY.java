public final class GotoXY extends State {

    private int duration;
    private final int speed;
    private final Vector2D vec;

    public GotoXY(int duration,Vector2D vec, int speed) {
      super(false, true);
      this.duration = duration;
      this.vec = vec;
      this.speed = speed;
    }
    public final void step(Entity e) {
        if (e.position.distanceTo(this.vec) < this.speed) {
          e.position.set(this.vec);
        } else {
          e.position.add(this.vec.minus(e.position).normalize().multiplyByScalar(this.speed));
        }
        // if (--this.duration <= 0) this.isOver = true;
        if (e.position.distanceTo(this.vec) < 1.0D) this.isOver = true;

    }
    public final String toString() {
      return "GotoXY";
    }
}
