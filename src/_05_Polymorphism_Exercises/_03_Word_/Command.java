package _05_Polymorphism_Exercises._03_Word_;

public class Command {

    private final String text;
    private final TextTransform textTransform;

    public Command(String text, TextTransform textTransform){
        this.text = text;
        this.textTransform = textTransform;
    }
    public String getText() {
        return this.text;
    }

    public TextTransform getTextTransform() {
        return this.textTransform;
    }
}
