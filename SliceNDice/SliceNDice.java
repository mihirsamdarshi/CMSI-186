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
        this.player = new Player[2];
        player[0] = new Player(50, numberOfDice, numberOfRiskyDiceP1);
        player[1] = new Player(50, numberOfDice, numberOfRiskyDiceP2);

        while(player[0].getHealth() > 0 || player[1].getHealth() > 0) {
            int roundNumber = 1;

            int playerOneHealth = player[0].getHealth();
            int playerTwoHealth = player[1].getHealth();

            player[0].rollAllDice();
            player[1].rollAllDice();

            int playerOneAttackScore = player[0].getAttackScore();
            int playerTwoAttackScore = player[1].getAttackScore();
            int playerOneDefenseScore = player[0].getDefenseScore();
            int playerTwoDefenseScore = player[1].getDefenseScore();
            int playerOneHealScore = player[0].getHealScore();
            int playerTwoHealScore = player[1].getHealScore();

            System.out.println("***" + "Round" + roundNumber + "***" + newLine + newLine);
            System.out.println("Player One" + newLine + "-----------" + newLine + "Health: " + playerOneHealth + newLine + player[0].toString() + newLine + "Attack: " + playerOneAttackScore + newLine + "Defense: " + playerOneDefenseScore + newLine + "Healing: " + playerOneHealScore + newLine);
            System.out.println("Player Two" + newLine + "-----------" + newLine + "Health: " + playerOneHealth + newLine + player[1].toString() + newLine + "Attack: " + playerOneAttackScore + newLine + "Defense: " + playerTwoDefenseScore + newLine + "Healing: " + playerTwoHealScore + newLine);

            int playerOneDamageDealt = playerOneAttackScore - playerOneDefenseScore - playerOneHealScore;
            int playerTwoDamageDealt = playerTwoAttackScore - playerTwoDefenseScore - playerTwoHealScore;

            player[0].setHealth(playerOneHealth - playerOneDamageDealt);
            player[1].setHealth(playerTwoHealth - playerTwoDamageDealt);
        }

        if (player[0].getHealth() > player[1].getHealth()) {
            return "###### GAME OVER ######" + newLine + "Player 1 wins " + player[0].getHealth() + "to " + player[1].getHealth();
        }
        else if (player[1].getHealth() > player[0].getHealth()) {
            return "###### GAME OVER ######" + newLine + "Player 2 wins " + player[1].getHealth() + "to " + player[0].getHealth();
        }
        else {
            return "###### GAME OVER ######" + newLine + "It's a tie!";
        }
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
When the game ends (either due to a player losing all health or 25 rounds have occured), a winner is declared. If both players have the same health, a tie is declared instead.
*/
}
