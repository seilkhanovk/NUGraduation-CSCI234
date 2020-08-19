import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class Common {
  public int windowWidth;
  public int windowHeight;
  public int numOfStudents;
  public UniversityMap map;
  public List academicians;
  public List speakers;
  public List students;
  public List assessments;
  public List assessmentsFactory;

  private final String[] studentNames = {"Abay", "Abilda", "Abilkhaiyr", "Ablan", "Abylaikhan", "Adil", "Adilzhan", "Adlet", "Aidana", "Aidyn",
      "Aigerim", "Aisana", "Akhmed", "Akmyrza", "Alan", "Aldamzhar", "Alexandra", "Ali", "Alibek", "Alim",
      "Alisher", "Allan", "Altair", "Altynay", "Altynbek", "Amangeldy", "Amina", "Anel", "Angsar", "Anuar",
      "Ardan", "Arman", "Askhat", "Assanali", "Assem", "Ayazhan", "Azamat", "Azizkhan", "Bagdat", "Baglan",
      "Bakdaulet", "Bakdauren", "Bakyt", "Batyrbek", "Batyrkhan", "Bauyrzhan", "Beibarys", "Bekzat", "Bota", "Damir",
      "Dana", "Danel", "Daniyar", "Darina", "Dastan", "Daulet", "Dauren", "Dinislam", "Dulat", "Eldar",
      "Emir", "Galym", "Gulnaz", "Islam", "Kamila", "Kamilla", "Karim", "Kassym", "Khadisha", "Khafiz",
      "Kuanysh", "Kyran", "Madi", "Madiyar", "Magzhan", "Makhambet", "Mansur", "Margulan", "Maxim", "Medet",
      "Meirzhan", "Miras", "Mokhira", "Murat", "Nargiza", "Nartay", "Nuradil", "Nurbolat", "Nurdaulet", "Nurlan",
      "Nursultan", "Nurtileu", "Olzhas", "Rabbani", "Raiymbek", "Rakhat", "Ramazan", "Ramilya", "Rauan", "Rollan",
      "Rustem", "Sabyr", "Sagi", "Saidgaffor", "Saken", "Salavat", "Sandugash", "Sanzhar", "Shapagat", "Sherkhan",
      "Shynggys", "Shyngys", "Tatyana", "Temirlan", "Temirzhan", "Timur", "Togzhan", "Tomiris", "Turgankhan", "Vladislav",
      "Yeldos", "Yerkali", "Yerkhan", "Yermek", "Yernar", "Yerzhan", "Yussup", "Zarina", "Zhalgas", "Zhanarys",
      "Zhandos", "Zhangeldi", "Zhannur", "Zhansaya", "Zhassulan", "Zhibek", "Zhuldyz" };

  public final State state;
  public boolean isAllCollected;
  public final Vector2D center;


  public Common (int numOfStudents, int windowWidth, int windowHeight) {
      this.numOfStudents = numOfStudents;
      this.windowWidth = windowWidth;
      this.windowHeight = windowHeight;
      this.map = new UniversityMap("NU", new Vector2D(0.0D, 0.0D), new Stationary(), this, "NUMap-Faded.jpg");
      this.academicians = new ArrayList();
      this.speakers = new ArrayList();
      this.students = new ArrayList();
      this.assessments = new ArrayList();
      this.assessmentsFactory = new ArrayList();
      this.state = new Stationary();
      this.center = new Vector2D((windowWidth * 564 / 800), (windowHeight * 326 / 400));
      this.assessmentsFactory.add(new LabFactory(this));
      this.assessmentsFactory.add(new QuizFactory(this));
      this.assessmentsFactory.add(new HomeworkFactory(this));
      Academician a1 = new Academician("Katsu", randStartingPosition(25), randomState(), this, "ShigeoKatsu.gif");
      Academician a2 = new Academician("Tourassis", randStartingPosition(25), randomState(), this, "VassiliosTourassis.gif");
      Academician a3 = new Academician("Nivelle", randStartingPosition(25), randomState(), this, "HansDeNivelle.gif");
      Academician a4 = new Academician("Temizer", randStartingPosition(25), randomState(), this, "SelimTemizer.gif");
      this.academicians.add(a1);
      this.academicians.add(a2);
      this.academicians.add(a3);
      this.academicians.add(a4);
      Speaker s1 = new Speaker("Tokayev", this.center.plus(new Vector2D(-100.0D, 0.0D)), this.state, this, "KassymJomartTokayev.gif");
      Speaker s2 = new Speaker("Nazarbayev", this.center.plus(new Vector2D(100.0D, 0.0D)), this.state, this, "NursultanNazarbayev.gif");
      this.speakers.add(s1);
      this.speakers.add(s2);
      for (int i = 0; i < numOfStudents; i++) {
        Student student = new Student(studentNames[randomInt(0, 136)], randStartingPosition(15), randomStateForStudent(), this);
        students.add(student);
      }
  }

  public final int randomInt(int from, int to) {
    Random num = new Random();
    int randNum = num.nextInt(to - from + 1) + from;
    return randNum;
  }

  private Vector2D randStartingPosition(int pos) {
      int x = randomInt(pos, this.windowWidth - pos);
      int y = randomInt(pos, this.windowHeight - pos);
      if (pos == -1) {
         x = randomInt(-20, 20);
         y = randomInt(-20, 20);
      }
      return new Vector2D(x, y);
  }

  private State randomState() {
    int num = randomInt(1, 3);
    if (num == 1) return new GotoXY(randomInt(30, 50), randStartingPosition(1), randomInt(2, 5));
    if (num == 2) return new ZigZag(randomInt(30, 50), randStartingPosition(-1), randomInt(2, 5));
    return new Rest(randomInt(30, 50));
  }

  private State randomStateForStudent() {
    int num = randomInt(1, 4);
    if (num == 1) return new GotoXY(randomInt(30, 50), randStartingPosition(1), randomInt(2, 5));
    if (num == 2) return new ZigZag(randomInt(30, 50), randStartingPosition(-1), randomInt(2, 5));
    if (num == 3) return new Rest(randomInt(30, 50));
    return new Closest(randomInt(30, 50), randomInt(2, 5));
  }

  public final void stepAllEnties() {
    Iterator it1 = this.academicians.iterator();
    while (it1.hasNext()) {
      Academician a1 = (Academician)it1.next();
      a1.step();
      if (!(a1.state instanceof Rest) && !(a1.state instanceof Stationary) && randomInt(1, 8) == 1) {
        AssessmentFactory c = (AssessmentFactory)a1.common.assessmentsFactory.get(randomInt(0, 2));

        int x = (int) a1.position.x + ((randomInt(0, 1) == 0) ? -1 : 1) * randomInt(15, 60);
        int y = (int) a1.position.y + ((randomInt(0, 1) == 0) ? -1 : 1) * randomInt(15, 60);
        if (x <= 0) x = 1;
        if (x >= this.windowWidth) x = this.windowWidth - 1;
        if (y <= 0) y = 1;
        if (y >= this.windowHeight) y = this.windowHeight - 1;

        this.assessments.add(c.createAssessment(new Vector2D(x, y)));
      }
      if (a1.state.isOver) {
        a1.state = randomState();
      }
    }
      it1 = this.students.iterator();
      while (it1.hasNext()) {

        Student s = (Student)it1.next();
        s.step();
        if (s.grade < 100) {
          for (int i = this.assessments.size() - 1; i >=0; i--) {
            Assessment ass = (Assessment)this.assessments.get(i);
            if (s.position.distanceTo(ass.position) <= 10D) {
              s.grade = s.grade + ass.points;
              this.assessments.remove(i);
            }
          }
        }
        if (s.state.isOver) {
          if (s.grade < 100) {
            s.state = randomStateForStudent();
          }else
          if (s.position.distanceTo(this.center) <= 25.0D) {
            s.state = this.state;
          }else {
            Vector2D vv = new Vector2D(randomInt(-10, 10), randomInt(-10, 10));
            s.state = new GotoXY(randomInt(30, 50),this.center.plus(vv), randomInt(2, 5));
          }
        }
      }
      boolean reached100 = true;
      Iterator it2 = this.students.iterator();
      while (it2.hasNext()) {
          Student s = (Student)it2.next();
          if (s.grade < 100) {
            reached100 = false;
            break;
          }
      }
      if (reached100 && !this.isAllCollected) {
        for (int i = 0; i < this.academicians.size(); i++) {
          Academician ac;
          Vector2D vv = new Vector2D((-150 + i * 100), -120.0D);
          (ac = (Academician)this.academicians.get(i)).position = this.center.plus(vv);
          ac.state = this.state;
        }
        this.isAllCollected = true;
      }
  }
}
