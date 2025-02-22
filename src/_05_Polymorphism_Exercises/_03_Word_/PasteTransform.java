package _05_Polymorphism_Exercises._03_Word_;

public class PasteTransform implements TextTransform {

    private CutTransform cutTransform;

    public PasteTransform(CutTransform cutTransform) {
        this.cutTransform = cutTransform;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        String cutPart = cutTransform.getCut();
        text.replace(startIndex, endIndex, cutPart);
    }
}
