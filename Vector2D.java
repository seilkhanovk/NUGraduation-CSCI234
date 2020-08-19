public final class Vector2D {
    public double x;
    public double y;

    public Vector2D (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public final void set (Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }
    public final double distanceTo (Vector2D other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }
    public final Vector2D normalize() {
        double d = Math.sqrt(Math.pow(this.x, 2.0D) + Math.pow(this.y, 2.0D));
        Vector2D v = new Vector2D(this.x / d, this.y / d);
        return v;
    }
    public final void add(Vector2D other) {
      this.x = this.x + other.x;
      this.y = this.y + other.y;
    }
    public final Vector2D plus (Vector2D other) {
        Vector2D p = new Vector2D(this.x + other.x, this.y + other.y);
        return p;
    }
    public final Vector2D minus (Vector2D other) {
        Vector2D m = new Vector2D(this.x - other.x, this.y - other.y);
        return m;
    }
    public final Vector2D multiplyByScalar (double scalar) {
        Vector2D mul = new Vector2D(this.x * scalar, this.y * scalar);
        return mul;
    }
}
