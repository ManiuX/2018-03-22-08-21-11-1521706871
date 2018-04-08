package practice11;


import java.util.*;

public class Teacher extends Person implements Observer {

    private Set<Klass> classes;

    public Teacher(int id, String name, int age, Set<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass klass: classes) {
            klass.addObserver(this);
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Set<Klass> getClasses() {
        return classes;
    }

    public void setClasses(Set<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        if(classes==null || classes.isEmpty()){
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }
        String classNums = "";
        for (Klass klass:classes  ) {
            classNums +=Integer.toString(klass.getNumber())+", ";
        }
        return super.introduce()+" I am a Teacher. I teach Class "+classNums.substring(0,classNums.length()-2)+".";
    }

    public boolean isTeaching(Student student){
        if(classes.isEmpty())
            return false;
        for (Klass klass:classes) {
            if(klass.isIn(student))
                return true;
        }
        return false;
    }

    public String introduceWith(Student student) {
        if (isTeaching(student)) {

            return "My name is " + this.getName() + ". I am " + this.getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        }
        return "My name is " + this.getName() + ". I am " + this.getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + ".";

    }


    @Override
    public void update(Observable o, Object arg) {
        //I am Tom. I know Jerry has joined Class 2.
        if(arg instanceof Klass){
            //I am Tom. I know Jerry become Leader of Class 2.
            Klass klass = (Klass) arg;
            Student leader = klass.getLeader();
            System.out.print("I am "+this.getName()+". I know "+leader.getName()+" become Leader of Class "+klass.getNumber()+".\n");
        }else if(arg instanceof Student){
            //I am Tom. I know Jerry has joined Class 2.
            Student student = (Student) arg;
            Klass klass = student.getKlass();
            System.out.print("I am "+this.getName()+". I know "+student.getName()+" has joined Class "+klass.getNumber()+".\n");
        }
    }
}
