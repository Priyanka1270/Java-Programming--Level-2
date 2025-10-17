import java.util.Scanner;
public class TicTacToe {
    private static char[][] board = new char[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean playAgain = true;

        System.out.println("=======================================");
        System.out.println("        WELCOME TO TIC-TAC-TOE         ");
        System.out.println("=======================================");

        while (playAgain) {
            initializeBoard();
            boolean gameEnded = false;
            while (!gameEnded) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " - Enter your move (row[1-3] and column[1-3]): ");

                int row = sc.nextInt() - 1;
                int col = sc.nextInt() - 1;
                if (!isValidMove(row, col)) {
                    System.out.println(" Invalid move! Try again.");
                    continue;
                }
                board[row][col] = currentPlayer;

                if (checkWinner(currentPlayer)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins the game!");
                    gameEnded = true;
                } else if (isDraw()) {
                    displayBoard();
                    System.out.println(" The game is a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.startsWith("y");
            currentPlayer = 'X'; 
        }

        System.out.println("\nThanks for playing Tic-Tac-Toe! ");
        sc.close();
    }
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; 
                }
            }
        }
        return true; 
    }
}
