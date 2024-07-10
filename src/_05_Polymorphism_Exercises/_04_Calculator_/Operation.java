package _05_Polymorphism_Exercises._04_Calculator_;

public interface Operation {
    void addOperand(int operand);

    int getResult();

    boolean isCompleted();
}
