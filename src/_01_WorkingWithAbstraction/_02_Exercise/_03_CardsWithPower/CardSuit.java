package _01_WorkingWithAbstraction._02_Exercise._03_CardsWithPower;

public enum CardSuit {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;


    CardSuit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
