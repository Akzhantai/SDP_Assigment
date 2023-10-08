import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WinCounter playerWins = new WinCounter(new Rock());
        WinCounter computerWins = new WinCounter(new Rock());

        while (true) {
            System.out.println("Choose your move: (Rock/Paper/Scissors)");
            String myMove = sc.nextLine();

            Move playerMove = myMoveCheck(myMove);
            if (playerMove != null) {

                Move compMove = computerMoveSelector();
                System.out.println("Computer's move:");
                String computerMove = compMove.makeMove();
                System.out.println(computerMove);

                determineWinner(playerMove, compMove, playerWins, computerWins);

                if (playerWins.getWins() == 3) {
                    System.out.println("You win the game!");
                    break;
                } else if (computerWins.getWins() == 3) {
                    System.out.println("Computer wins the game!");
                    break;
                }
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }
    private static Move myMoveCheck(String move) {
        return switch (move) {
            case "Rock" -> new  Rock();
            case "Paper" -> new Paper();
            case "Scissors" -> new Scissors();
            default -> null;
        };
    }

    private static Move computerMoveSelector() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        int select = RandomGenerator.getInstance().nextInt(moves.length);
        return myMoveCheck(moves[select]);
    }
    private static void determineWinner(Move player, Move computer, WinCounter playerWins, WinCounter computerWins) {
        String playerMove = player.makeMove();
        String computerMove = computer.makeMove();

        if (playerMove.equals(computerMove)) {
            System.out.println("It's a tie!");
        } else if (
                (playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                        (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                        (playerMove.equals("Scissors") && computerMove.equals("Paper"))
        ) {
            System.out.println("You win this round!");
            playerWins.incrementWins();
        } else {
            System.out.println("Computer wins this round!");
            computerWins.incrementWins();
        }

        System.out.println("Score: You " + playerWins.getWins() + " - " + computerWins.getWins() + " Computer");
    }
}