public class Main {
    public static void main(String[] args) {
        import java.util.Scanner;

        public class TicTacToe {

            private static char[][] board;
            private static char currentPlayer;
            private static boolean gameOver;

            public static void main(String[] args) {
                initializeBoard();
                currentPlayer = 'X';
                gameOver = false;
                while (!gameOver) {
                    printBoard();
                    makeMove();
                    checkGameOver();
                    switchPlayer();
                }
                printBoard();
                System.out.println("Game Over!");
            }

            private static void initializeBoard() {
                board = new char[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[i][j] = '-';
                    }
                }
            }

            private static void printBoard() {
                System.out.println("-------------");
                for (int i = 0; i < 3; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(board[i][j] + " | ");
                    }
                    System.out.println();
                    System.out.println("-------------");
                }
            }

            private static void makeMove() {
                Scanner scanner = new Scanner(System.in);
                int row, col;
                do {
                    System.out.print("Enter row (1-3) and column (1-3) for " + currentPlayer + ": ");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
                } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-');
                board[row][col] = currentPlayer;
            }

            private static void checkGameOver() {
                for (int i = 0; i < 3; i++) {
                    // check rows
                    if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                        gameOver = true;
                        return;
                    }
                    // check columns
                    if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                        gameOver = true;
                        return;
                    }
                }
                // check diagonals
                if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                    gameOver = true;
                    return;
                }
                if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                    gameOver = true;
                    return;
                }
                // check if board is full
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == '-') {
                            return;
                        }
                    }
                }
                gameOver = true;
            }

            private static void switchPlayer() {
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            }
        }

    }
}