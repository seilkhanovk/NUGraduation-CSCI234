public final class ZigZag extends State {
    private final int speed;
    private int duration;
    private final Vector2D vec;
    public ZigZag(int duration, Vector2D vec, int speed) {
        super(false, true);
        this.speed = speed;
        this.duration = duration;
        this.vec = vec.normalize();
    }
    public final void step(Entity e) {
        e.position.add(this.vec.multiplyByScalar(this.speed));
        if (e.position.x <= 0.0D || e.position.x >= e.common.windowWidth)
        this.vec.x = -this.vec.x;
        if (e.position.y <= 0.0D || e.position.y >= e.common.windowHeight)
        this.vec.y = -this.vec.y;
        if (--this.duration <= 0) this.isOver = true;
    }
    public final String toString() {return "ZigZag";}
}
