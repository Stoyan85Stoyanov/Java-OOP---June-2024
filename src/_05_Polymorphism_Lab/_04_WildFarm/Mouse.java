package _05_Polymorphism_Lab._04_WildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    protected void eat(Food food) throws Exception {
        if(!(food instanceof Vegetable)){
            throw new Exception("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}
