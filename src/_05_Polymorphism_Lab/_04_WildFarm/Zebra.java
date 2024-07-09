package _05_Polymorphism_Lab._04_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    protected void eat(Food food) throws Exception {
        if(!(food instanceof Vegetable)){
            throw new Exception("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
