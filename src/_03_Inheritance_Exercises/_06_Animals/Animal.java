package _03_Inheritance_Exercises._06_Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String produceSound() {
        return null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        builder.append(getName()).append(" ").append(getAge()).append(" ").append(getGender()).append(System.lineSeparator());
        builder.append(produceSound());

        return builder.toString();
    }
}
