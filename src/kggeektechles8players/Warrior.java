package kggeektechles8players;

 import kggeektechles8game.RPG_game;

import java.util.Random;

    public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int randomCRITICAL_DAMAGE = RPG_game.random.nextInt(3) + 2;
        boss.setHealth(boss.getHealth() - randomCRITICAL_DAMAGE * this.getDamage()) ;

    }
}
