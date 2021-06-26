package kggeektechles8game;

import kggeektechles8players.*;

import java.util.Random;

    public class  RPG_game {
        public static Random random = new Random();

        public static void start() {

            Boss boss = new Boss(970, 50);

            Warrior warrior = new Warrior(260, 15);
            Medic doc = new Medic(230, 5, 15);
            Magic magic = new Magic(270, 20);
            Berserk berserk = new Berserk(250, 20);
            Medic assistant = new Medic(280, 10, 5);
            Witcher witcher = new Witcher(265, 0);
            Hero[] heroes = {warrior, doc, magic, berserk, assistant, witcher};

            printStatistics(boss, heroes);
            while (!isGameFinished(boss, heroes)) {
                round(boss, heroes);
            }
        }

        private static void round(Boss boss, Hero[] heroes) {
            if (boss.getHealth() > 0) {
                bossHits(boss, heroes);
            }
            heroesHit(boss, heroes);
            applySuperPower(boss, heroes);
            printStatistics(boss, heroes);
        }

        private static void printStatistics(Boss boss, Hero[] heroes) {
            System.out.println("_______________");
            System.out.println("Boss health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
            for (int i = 0;i < heroes.length; i++ ) {
                System.out.println(heroes[i].getClass().getSimpleName()
                        + " health: " + heroes[i].getHealth()
                        + " [" + heroes[i].getDamage() + "]");
            }
        }

        private static void applySuperPower(Boss boss, Hero[] heroes) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].applySuperAbility(boss, heroes);
                }
            }
        }

        private static void bossHits(Boss boss, Hero[] heroes) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                }
            }
        }

        private static void heroesHit(Boss boss, Hero[] heroes) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }
            }
        }

        private static boolean isGameFinished(Boss boss, Hero[] heroes) {
            if (boss.getHealth() <= 0) {
                System.out.println("Heroes won!!!");
                return true;
            }

            boolean allHeroesDead = true;
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    allHeroesDead = false;
                    break;
                }
            }
            if (allHeroesDead) {
                System.out.println("Boss won!!!");
            }
            return allHeroesDead;
        }



}
