package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputInterpreter {

    private final CalculationEngine engine;
    private final Deque<Integer> memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new ArrayDeque<>();
    }

    public void interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));

        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
    }

    public Operation getOperation(String operation) {

        return switch (operation) {

            case "*" -> new MultiplicationOperation();
            case "/" -> new DivisionOperation();
            case "ms" -> new MemorySafeOperation(this.memory);
            case "mr" -> new MemoryRecallOperation(this.memory);
            default -> null;
        };
    }
}
