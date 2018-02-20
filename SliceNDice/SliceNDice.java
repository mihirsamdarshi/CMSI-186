/*
SliceNDice.java, which plays a two player game as follows when run from the command line:
*/
public class SliceNDice {
    public static final int DEFAULT_NUMBER_OF_DICE = 7;
    public static final int DEFAULT_NUMBER_OF_RISKY_DICE = 1;
    static String newLine = System.getProperty("line.separator");
    private static Player[] player = new Player[2];

    public static String standardGame() {
        int roundNumber = 1;
        while(player[0].getHealth() > 0 || player[1].getHealth() > 0 || roundNumber == 50) {

            int playerOneHealth = player[0].getHealth();
            int playerTwoHealth = player[1].getHealth();

            player[0].rollAllDice();
            player[1].rollAllDice();

            System.out.println("***" + "Round" + roundNumber + "***" + newLine + newLine);
            System.out.println("Player One" + newLine + "-----------" + player[0].toString());
            System.out.println("Player Two" + newLine + "-----------" + newLine + player[1].toString());

            int playerOneAttackScore = player[0].getAttackScore();
            int playerOneDefenseScore = player[0].getDefenseScore();
            int playerOneHealScore = player[0].getHealScore();
            int playerTwoAttackScore = player[1].getAttackScore();
            int playerTwoDefenseScore = player[1].getDefenseScore();
            int playerTwoHealScore = player[1].getHealScore();

            int playerOneDamageDealt = playerOneAttackScore - playerOneDefenseScore - playerOneHealScore;
            int playerTwoDamageDealt = playerTwoAttackScore - playerTwoDefenseScore - playerTwoHealScore;

            player[0].setHealth(playerOneHealth - playerOneDamageDealt);
            player[1].setHealth(playerTwoHealth - playerTwoDamageDealt);
            roundNumber++;
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

    public static void main (String[] args) {
        if (args.length == 0) {
            int numberOfDice = DEFAULT_NUMBER_OF_DICE;
            int numberOfRiskyDiceP1 = DEFAULT_NUMBER_OF_RISKY_DICE;
            int numberOfRiskyDiceP2 = DEFAULT_NUMBER_OF_RISKY_DICE;
            player[0] = new Player(50, numberOfDice, numberOfRiskyDiceP1);
            player[1] = new Player(50, numberOfDice, numberOfRiskyDiceP2);
            standardGame();
        } else if (args.length == 1) {
            try {
                    int numberOfDice = Integer.parseInt(args[0]);
                    int numberOfRiskyDiceP1 = DEFAULT_NUMBER_OF_RISKY_DICE;
                    int numberOfRiskyDiceP2 = DEFAULT_NUMBER_OF_RISKY_DICE;
                    player[0] = new Player(50, numberOfDice, numberOfRiskyDiceP1);
                    player[1] = new Player(50, numberOfDice, numberOfRiskyDiceP2);
            } catch (Exception e) {
                System.out.println("Please input valid numerical arguments, or to start a standard game, none at all");
            }
        } else if (args.length == 2) {
            try {
                    int numberOfDice = Integer.parseInt(args[0]);
                    int numberOfRiskyDiceP1 = Integer.parseInt(args[1]);
                    int numberOfRiskyDiceP2 = Integer.parseInt(args[1]);
                    player[0] = new Player(50, numberOfDice, numberOfRiskyDiceP1);
                    player[1] = new Player(50, numberOfDice, numberOfRiskyDiceP2);
            } catch (Exception e) {
                System.out.println("Please input numerical valid arguments, or to start a standard game, none at all");
            }
        } else if (args.length == 3) {
            try {
                    int numberOfDice = Integer.parseInt(args[0]);
                    int numberOfRiskyDiceP1 = Integer.parseInt(args[1]);
                    int numberOfRiskyDiceP2 = Integer.parseInt(args[2]);
                    player[0] = new Player(50, numberOfDice, numberOfRiskyDiceP1);
                    player[1] = new Player(50, numberOfDice, numberOfRiskyDiceP2);
            } catch (Exception e) {
                System.out.println("Please input numerical valid arguments, or to start a standard game, none at all");
            }
        } else {
            System.out.println("Please input numerical valid arguments, or to start a standard game, none at all");
        }
    }

/*
When the game ends (either due to a player losing all health or 25 rounds have occured), a winner is declared. If both players have the same health, a tie is declared instead.
*/
}
