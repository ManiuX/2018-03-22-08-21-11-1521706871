package practice09;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public String introduce() {
        if (this.getKlass().getLeader() != null) {
            return super.introduce() + String.format( " I am a Student. I am Leader of Class %d.",this.getKlass().getNumber()) ;
        }
        return super.introduce() + String.format( " I am a Student. I am at Class %d.",this.getKlass().getNumber()) ;
    }
}
