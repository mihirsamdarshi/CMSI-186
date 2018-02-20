/*
SliceNDice.java, which plays a two player game as follows when run from the command line:
*/
//TODO: fill out standardGame
public class SliceNDice {
    public static final int DEFAULT_NUMBER_OF_DICE = 7;
    public static final int DEFAULT_NUMBER_OF_RISKY_DICE = 1;
    public Player[] player;
    String newLine = System.getProperty("line.separator");

    public String standardGame (int numberOfDice, int numberOfRiskyDiceP1, int numberOfRiskyDiceP2) {
        int roundNumber = 1;

        this.player = new Player[2];
        player[0] = new Player(50, numberOfDice, numberOfRiskyDiceP1);
        player[1] = new Player(50, numberOfDice, numberOfRiskyDiceP2);

        while(player[0].getHealth() > 0 || player[1].getHealth() > 0) {
            System.out.println("Player One" + newLine + "-----------" + newLine + "Health: " + player[0].getHealth());
        }

        return "###### GAME OVER ######";

    }

    public void main (String[] args) {
        if (args.length == 0) {
            int numberOfDice = DEFAULT_NUMBER_OF_DICE;
            int numberOfRiskyDiceP1 = DEFAULT_NUMBER_OF_RISKY_DICE;
            int numberOfRiskyDiceP2 = DEFAULT_NUMBER_OF_RISKY_DICE;
            standardGame(numberOfDice, numberOfRiskyDiceP1, numberOfRiskyDiceP2);
        } else if (args.length == 1) {
            try {
                    int numberOfDice = Integer.parseInt(args[0]);
                    int numberOfRiskyDiceP1 = DEFAULT_NUMBER_OF_RISKY_DICE;
                    int numberOfRiskyDiceP2 = DEFAULT_NUMBER_OF_RISKY_DICE;
                    standardGame(numberOfDice, numberOfRiskyDiceP1, numberOfRiskyDiceP2);
            } catch (Exception e) {
                System.out.println("Please input valid arguments, or to start a standard game, none at all");
            }
        } else if (args.length == 2) {
            try {
                    int numberOfDice = Integer.parseInt(args[0]);
                    int numberOfRiskyDiceP1 = Integer.parseInt(args[1]);
                    int numberOfRiskyDiceP2 = Integer.parseInt(args[1]);
                    standardGame(numberOfDice, numberOfRiskyDiceP1, numberOfRiskyDiceP2);
            } catch (Exception e) {
                System.out.println("Please input valid arguments, or to start a standard game, none at all");
            }
        } else if (args.length == 3) {
            try {
                    int numberOfDice = Integer.parseInt(args[0]);
                    int numberOfRiskyDiceP1 = Integer.parseInt(args[1]);
                    int numberOfRiskyDiceP2 = Integer.parseInt(args[2]);
                    standardGame(numberOfDice, numberOfRiskyDiceP1, numberOfRiskyDiceP2);
            } catch (Exception e) {
                System.out.println("Please input valid arguments, or to start a standard game, none at all");
            }
        } else {
            System.out.println("Please input valid arguments, or to start a standard game, none at all");
        }
    }

/*

When run from the command line with any other number of arguments or if any invalid arguments are provided (non-integers, negative number of dice, more risky dice than the player has, etc.), SliceNDice will print out usage instructions indicating acceptable arguments.

During a game, SliceNDice should print out the results of each round, including the results of each player's rolled dice, their scored values, damage dealt and healed from each player.

When the game ends (either due to a player losing all health or 25 rounds have occured), a winner is declared. If both players have the same health, a tie is declared instead.
*/
}
