package _04_InterfacesAndAbstraction_Exercises._07_CollectionHierarchy;


public class AddCollection extends Collection implements Addable {

    public AddCollection() {
        super();
    }

    @Override
    public int add(String item) {
        getItems().add(item);
        return getItems().indexOf(item);
    }
}
