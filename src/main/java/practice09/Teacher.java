package practice09;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public String introduce() {
        Klass klass = this.getKlass();
        if (klass != null) {
            return super.introduce() + " I am a Teacher. I teach Class " + this.getKlass().getNumber() + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        int teacherNumber = this.getKlass().getNumber();
        int studentNumber = student.getKlass().getNumber();
        if (teacherNumber == studentNumber) {
            return super.introduce() + String.format( " I am a Teacher. I teach %s." ,student.getName());

        }
        return super.introduce() + String.format( " I am a Teacher. I don't teach %s." ,student.getName());
    }
}
