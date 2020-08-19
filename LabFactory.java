public final class LabFactory extends AssessmentFactory {
    public LabFactory(Common common) {super(common);}
    public final Assessment createAssessment(Vector2D position) {
      return new Lab("Lab", position, this.common.state, this.common, this.common.randomInt(2, 4));
    }
}
