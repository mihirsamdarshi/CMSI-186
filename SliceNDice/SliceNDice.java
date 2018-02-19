/*
SliceNDice.java, which plays a two player game as follows when run from the command line:
*/
public class SliceNDice {
    private String[] args;
    public static void standardGame () {

    }

/*
When run from the command line with no arguments, SliceNDice will play a game with 7 dice for each player, 1 of which will be "risky" and 6 of which will be "safe".

When run from the command line with 1 integer argument, SliceNDice will play a game with a number of dice equal to the given argument for each player, 1 of which will be "risky" with the remaining "safe".

When run from the command line with 2 integer arguments, SliceNDice will play a game with a number of dice equal to the first argument for each player; the number of "risky" dice both players have will be equal to the second argument with the remaining as "safe" dice.

When run from the command line with 3 integer arguments, SliceNDice will play a game with a number of dice equal to the first argument for each player; the number of "risky" dice the first player has will be equal to the second argument, while the second player will have a number of "risky" dice equal to the third argument. All non-"risky" dice belonging to either player will be "safe".

When run from the command line with any other number of arguments or if any invalid arguments are provided (non-integers, negative number of dice, more risky dice than the player has, etc.), SliceNDice will print out usage instructions indicating acceptable arguments.

During a game, SliceNDice should print out the results of each round, including the results of each player's rolled dice, their scored values, damage dealt and healed from each player.

When the game ends (either due to a player losing all health or 25 rounds have occured), a winner is declared. If both players have the same health, a tie is declared instead.
*/
}
