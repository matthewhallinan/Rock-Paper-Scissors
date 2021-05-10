/* There is not a lot of commenting because effort is taken to make the code self-evident */

import java.util.Scanner;

public class RPS {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Opponent opponent = new Opponent();
        MoveType playerMove = null;
        MoveType opponentMove = null;

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("When prompted, please press R for rock, P for paper, S for scissors");

        int roundsLeft = getNumRounds(scan);

        while( roundsLeft > 0 ){

            System.out.println("Please enter your move: ");

            while( playerMove == null ){
                playerMove = MoveType.parseMove(scan.next().toLowerCase());
                if (playerMove == null) {
                    System.out.println("Invalid move choice. Please enter your move: ");
                }
            }

            opponentMove = MoveType.parseMove( opponent.pickMove() );
            System.out.println("The computer chose " + opponentMove.toString());

            if ( playerMove.equals(opponentMove) ){
                System.out.println("Uh oh! You both picked " + playerMove.toString() + "! It's a draw!");
            }else if( playerMove.trumps(opponentMove)){
                System.out.println(playerMove.toString() + " " + playerMove.getTrumpType() + " " + opponentMove.toString() + "! Victory!");
            }else{
                System.out.println("Oh no! " + opponentMove.toString() + " " + opponentMove.getTrumpType() + " " + playerMove.toString() + "! You lose!");
            }

            roundsLeft --;
            playerMove = null;

        }

        System.out.println("Thanks for playing!");

    }

    private static int getNumRounds(Scanner scan){
        System.out.println("How many rounds would you like to play?");
        String numRoundsString = scan.next();

        //Ensure input String is a number
        while( true ){
            if( numRoundsString.matches("-?\\d+") != true ) {
                System.out.println("Invalid number of rounds. Please enter a number.");
                numRoundsString = scan.next();
            }
            else{
                break;
            }
        }

        int numRounds = Integer.parseInt( numRoundsString );
        return numRounds;
    }

}
