package _04_InterfacesAndAbstraction_Exercises._07_CollectionHierarchy;


import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    private final int maxSize = 100;
    private final List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }

    protected List<String> getItems() {
        return this.items;
    }
}
