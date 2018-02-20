/**
 * <P>A class a Player in the SliceNDice game.
 * <P>Each player has a set of dice made for the game as well as a health total.
 *
 * @author Mihir Samdarshi
 */

public class Player {
    /**
     * The initial health given for a player if no other health total is
     * specified.
     */
    public static final int DEFAULT_STARTING_HEALTH = 50;
    private int health;
    private CombatDie[] dice;
    static String newLine = System.getProperty("line.separator");

    /**
     * Constructs a Player with the given health and an array of dice of the
     * given length. Of those dice, the number of dice that are "risky" dice
     * should be equal to the given number of risky dice, with the remaining
     * dice as "safe" dice.
     *
     * @param startingHealth    the player's initial health value
     * @param numberOfDice      the number of the dice in the player's
     *                          array of combatDie
     * @param numberOfRiskyDice the number of RiskyDie in the player's
     *                          array of combatDie
     * @throws IllegalArgumentException if numberOfRiskyDice is greater than
     *                                  numberOfDice
     */
    public Player(int startingHealth, int numberOfDice, int numberOfRiskyDice) {
        if (numberOfRiskyDice > numberOfDice) {
            throw new IllegalArgumentException();
        }
        health = startingHealth;
        dice = new CombatDie[numberOfDice];
        for (int i = 0; i < numberOfRiskyDice; i++) {
            dice[i] = new RiskyDie();
        }
        for (int i = numberOfRiskyDice; i < numberOfDice; i++) {
            dice[i] = new SafeDie();
        }
    }

    /**
     * Constructs a Player with the default health of 50 and an array of dice
     * of the given length. Of those dice, the number of dice that are "risky"
     * dice should be equal to the given number of risky dice, with the
     * remaining dice as "safe" dice.
     *
     * @param numberOfDice      the number of the dice in the player's
     *                          array of combatDie
     * @param numberOfRiskyDice the number of RiskyDie in the player's
     *                          array of combatDie
     * @throws IllegalArgumentException if numberOfRiskyDice is greater than
     *                                  numberOfDice
     */
    public Player(int numberOfDice, int numberOfRiskyDice) {
        health = DEFAULT_STARTING_HEALTH;
        if (numberOfRiskyDice > numberOfDice) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns this Player's current health.
     *
     * @return this Player's health value.
     */
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * Returns the CombatDie at the given index in the Player's array of dice.
     *
     * @param index the index of the die within the Player's arry of dice
     * @return the CombatDie at the given index
     */
    public CombatDie getDieAtIndex(int index) {
        return dice[index];
    }

    /**
     * Rolls all dice belonging to this player, randomly changing the face-up
     * side of each die.
     */
    public void rollAllDice() {
        for (int i = 0; i < dice.length; i++) {
            dice[i].roll();
        }
    }

    /**
     * Counts the total value of the given faceType among the face-up sides of
     * this Player's dice.
     *
     * @param faceType the FaceType being searched for
     * @return the total values of the face-up sides with the given
     * FaceType among the Player's CombatDie array
     */
    public int countOfFaceType(DiceFace.FaceType faceType) {
        int count = 0;
        for (int i = 0; i < dice.length; i++) {
            if (faceType.equals(dice[i].getFaceUp().getFaceType())) {
                count += dice[i].getFaceUp().getFaceValue();
            }
        }
        return count;
    }

    /**
     * Returns whether there is at least one face-up Broken Shield among the
     * Player's dice.
     *
     * @return <code>true</code> if at least one CombatDie among the player's
     * dice has a Broken Shield DiceFace as it's face up side;
     * <code>false</code> otherwise.
     */
    public boolean containsBrokenShield() {
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] instanceof RiskyDie && dice[i].getFaceUp().getFaceType().equals(DiceFace.FaceType.BROKEN_SHIELD)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    /**
     * Calculates the attack score of the Player's dice by totaling the values
     * of all face-up Sword faces among the player's dice.
     *
     * @return the attack score determined by totaling the values of all face-up
     * Sword DiceFaces among the player's dice.
     */
    public int getAttackScore() {
        int swordValue = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i].getFaceUp().getFaceType().equals(DiceFace.FaceType.SWORD)) {
                swordValue += (dice[i].getFaceUp().getFaceValue());
            }
        }
        return swordValue;
    }

    /**
     * Calculates the defense score of the Player's dice by totaling the values
     * of all face-up Shield faces among the player's dice. If any Broken Shield
     * faces are face-up among the Player's dice, the defense score instead
     * becomes 0.
     *
     * @return the defense score determined by totaling the values of all face-up
     * Shield DiceFaces among the player's dice; if a Broken Shield face
     * is face-up, then the returned score is instead 0.
     */
    public int getDefenseScore() {
        int shieldValue = 0;
        for (int i = 0; i < dice.length; i++) {
            System.out.println(dice[i].getFaceUp().getFaceType());
            if (dice[i].getFaceUp().getFaceType().equals(DiceFace.FaceType.SHIELD)) {
                shieldValue += 1;
            }
        }
        return shieldValue;
    }

    /**
     * Calculates the heal score of the Player's dice by totaling the values
     * of all face-up Heal faces among the player's dice.
     *
     * @return the heal score determined by totaling the values of all face-up
     * Heal DiceFaces among the player's dice.
     */
    public int getHealScore() {
        int healValue = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i].getFaceUp().getFaceType().equals(DiceFace.FaceType.HEAL)) {
                healValue += 1;
            }
        }
        return healValue;
    }

    /**
     * Returns a string representation of the Player, including health, face-up
     * sides of the dice, and the scored attack, defense, and heal values based
     * upon those dice.
     *
     * @return a String representation of the Player
     */
    @Override
    public String toString() {
        String output =  "Health: ";
        output += health + newLine;
        output += "{ ";
        for (int i = 0; i < dice.length - 1; i++) {
            output += dice[i].getFaceUp() + ", ";
        }
        output += dice[dice.length - 1].getFaceUp() + " }" + newLine;
        output += "Attack: " + getAttackScore() + newLine;
        output += "Defense: " + getDefenseScore() + newLine;
        output += "Healing: " + getHealScore() + newLine;
        return output;
    }
}
