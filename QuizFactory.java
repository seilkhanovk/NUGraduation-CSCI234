public final class QuizFactory extends AssessmentFactory {
    public QuizFactory(Common common) {super(common);}
    public final Assessment createAssessment(Vector2D position) {
      return new Quiz("Quiz", position, this.common.state, this.common, this.common.randomInt(3, 5));
    }
}
