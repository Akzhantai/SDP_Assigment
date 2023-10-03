import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your move(Rock/Paper/Scissors:");
        String myMove = sc.nextLine();
        Move myMoveStrategy = playerMove(myMove);
        if (myMoveStrategy != null) {
            // Get the computer's move using the Singleton RandomGenerator
            Move compMoveStrategy = computerMove();
            System.out.println();
            System.out.println("Computer's move:");
            System.out.println(compMoveStrategy.makeMove());

            whoIsWinner(myMoveStrategy, compMoveStrategy);
        } else {
            System.out.println("Invalid input!");
        }
    }
    private static Move playerMove(String move) {
        return switch (move.toLowerCase()) {
            case "rock" -> new  Rock();
            case "paper" -> new Paper();
            case "scissors" -> new Scissors();
            default -> null;
        };
    }

    private static Move computerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        int select = RandomGenerator.getInstance().nextInt(moves.length);
        return playerMove(moves[select]);
    }

    private static void whoIsWinner(Move player, Move computer) {
        String playerMove = player.makeMove();
        String computerMove = computer.makeMove();

        System.out.println();

        if (playerMove.equals(computerMove)) {
            System.out.println("Tie!");
        } else if (
                (playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                        (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                        (playerMove.equals("Scissors") && computerMove.equals("Paper"))
        ) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}