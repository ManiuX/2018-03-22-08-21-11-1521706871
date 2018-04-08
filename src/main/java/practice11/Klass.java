package practice11;

import java.util.Objects;
import java.util.Observable;

public class Klass extends Observable {

    private int number;
    private Student leader;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Klass(int number) {
        this.number = number;
    }

    public String getDisplayName(){
        return "Class "+getNumber();
    }

    public void assignLeader(Student student){
        if(!student.getKlass().equals(this)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = student;
        setChanged();
        notifyObservers(this);
    }

    public void appendMember(Student student){
        student.setKlass(this);
        setChanged();
        notifyObservers(student);
    }

    public boolean isIn(Student student){
        return student.getKlass().equals(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number &&
                Objects.equals(leader, klass.leader);
    }

    @Override
    public int hashCode() {
        return number;
    }
}
