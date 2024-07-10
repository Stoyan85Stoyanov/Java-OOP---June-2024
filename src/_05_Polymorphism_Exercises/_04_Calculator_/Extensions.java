package _05_Polymorphism_Exercises._04_Calculator_;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {

        return new InputInterpreter(engine);
    }
}
