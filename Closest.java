import java.util.Iterator;
import java.util.List;

public final class Closest extends State {
    private int scalar;
    private int duration;

    public Closest(int duration, int scalar) {
      super(false, true);
      this.scalar = scalar;
      this.duration = duration;
    }
    public final void step(Entity e) {
        Assessment assessment = null;
        double maxDist = Double.MAX_VALUE;
        List<Assessment> l = e.common.assessments;
        for (Assessment grade: l) {
          double dist;
          if ((dist = e.position.distanceTo(grade.position)) < maxDist) {
            maxDist = dist;
            assessment = grade;
          }
        }
        if (assessment != null) {
          if (maxDist < this.scalar) {
            e.position.set(assessment.position);
          }else {
            e.position.add(assessment.position.minus(e.position).normalize().multiplyByScalar(this.scalar));
          }
        }
        if (--this.duration <= 0)
        this.isOver = true;
    }
    public final String toString() {
      return "Closest";
    }
}
