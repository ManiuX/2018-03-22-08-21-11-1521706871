package practice04;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String introduce(){
        String str=String.format("My name is %s. I am %d years old.", this.name,this.age);
        return str;
    }

    public String intro() {
        return String.format("My name is %s. I am %d years old.", this.name,this.age);
    }
}
