package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.models.units;


public class Gunner extends AbstractUnit {

    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
