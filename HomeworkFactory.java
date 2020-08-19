public final class HomeworkFactory extends AssessmentFactory {
    public HomeworkFactory(Common common) {super(common);}
    public final Assessment createAssessment(Vector2D position) {
      return new Homework("Homework", position, this.common.state, this.common, this.common.randomInt(1, 3));
    }
}
