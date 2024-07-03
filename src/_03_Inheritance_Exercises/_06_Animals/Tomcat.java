package _03_Inheritance_Exercises._06_Animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
