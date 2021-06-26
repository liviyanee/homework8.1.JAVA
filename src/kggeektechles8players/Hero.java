package kggeektechles8players;

public abstract class Hero  extends GameEntity implements HavingSuperAbility {

    private SuperAbility superAbility;

    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}

