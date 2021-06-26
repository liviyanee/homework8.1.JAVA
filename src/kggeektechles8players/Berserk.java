package kggeektechles8players;

import kggeektechles8game.RPG_game;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int SAVE_DAMAGE_AND_REVERT = RPG_game.random.nextInt(50);
        boss.setHealth(boss.getHealth()-SAVE_DAMAGE_AND_REVERT - this.getDamage());
    }




}




