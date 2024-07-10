package _05_Polymorphism_Exercises._03_Word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }
}
