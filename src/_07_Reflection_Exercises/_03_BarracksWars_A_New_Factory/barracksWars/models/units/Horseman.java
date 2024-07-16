package _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.models.units;

public class Horseman extends AbstractUnit{

    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
