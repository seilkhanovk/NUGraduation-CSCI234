public final class Rest extends State {
    private int duration;

    public Rest(int duration) {
      super(false, true);
      this.duration = duration;
    }

    public final void step(Entity e) {
        if (--this.duration <= 0)
        this.isOver = true;
    }

    public final String toString() {
      return "Rest";
    }
}
