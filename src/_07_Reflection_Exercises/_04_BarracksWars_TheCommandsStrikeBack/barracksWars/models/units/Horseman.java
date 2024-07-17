package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.models.units;


public class Horseman extends AbstractUnit {

    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
