package kggeektechles8players;

public class Witcher extends Hero {

    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.INVISIBILITY);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth()==0 && heroes[i] != this){
               heroes[i].setHealth(getHealth()+this.getHealth());
               this.setHealth(0);
            }
        }
        System.out.println("Witcher health " + this.getHealth());


    }
}
