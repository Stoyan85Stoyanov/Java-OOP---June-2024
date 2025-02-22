package _05_Polymorphism_Exercises._04_Calculator_;

import java.util.Deque;

public class MemorySafeOperation implements Operation {

    private final Deque<Integer> memory;

    public MemorySafeOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
