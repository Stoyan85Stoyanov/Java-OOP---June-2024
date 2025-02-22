package _04_InterfacesAndAbstraction_Lab._04_SayHelloExtended;

public abstract class BasePerson implements Person {

    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
