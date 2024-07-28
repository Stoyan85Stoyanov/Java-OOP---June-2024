package catHouse.entities.toys;

public class Ball extends BaseToy{ // наследявава BaseToy

    private static final int BALL_SOFTNESS = 1;
    private static final double BALL_PRICE = 10;
    public Ball() {  // Constructor should take no values upon initialization
        super(BALL_SOFTNESS, BALL_PRICE); // The ball has a softness of 1 and a price of 10
    }

}
