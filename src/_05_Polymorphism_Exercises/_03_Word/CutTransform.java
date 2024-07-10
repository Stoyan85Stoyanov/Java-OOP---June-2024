package _05_Polymorphism_Exercises._03_Word;

public class CutTransform implements TextTransform {

    private String cut;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {


        String cutPart = text.substring(startIndex, endIndex);
        setCut(cutPart);

        text.delete(startIndex, endIndex);
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }
}
