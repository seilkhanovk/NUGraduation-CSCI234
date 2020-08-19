public abstract class State {
    public boolean isOver = false;
    public boolean isVisible = true;

    public State (boolean isOver, boolean isVisible) {};
    public abstract void step (Entity e);

}
