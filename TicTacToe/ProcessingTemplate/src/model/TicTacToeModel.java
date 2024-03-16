package model;

/**
 * Die TicTacToeModel-Klasse implementiert die ITicTacToeModel interface
 * und stellt das Modell des Tic Tac Toe-Spiels dar.
 * Es verwaltet den Spielzustand, die Spielzüge des Spielers und bietet Methoden zur Überprüfung des Spielzustands.
 */
public class TicTacToeModel implements ITicTacToeModel {

    /**
     * symbol representing an empty space on the board
     */
    public final char EMPTY = '_';

    /**
     * Symbol des ersten Spieler
      */
    public final char PLAYER_1 = 'X';

    // Symbol des zweitens Spielers
    public final char PLAYER_2 = 'O';

    /* Spielfield mit 9 Einträgen */
    private char[] gameState;

    /* Counts the moves. Even moves are for PLAYER_1; odd moves are for PLAYER_2. */
    public char moveCount = 0;

   /*public static void main(String[] args) {
        var game = new TicTacToeModel();
        game.move(1);
        game.move(2);
        game.move(4);
        System.out.println("Field 4 is: "+ game.getFieldEntry(4));
    }*/

    /**
     * Konstruktor der TicTacToeModel class, der eine neue Klasse initialisiert
     */
    public TicTacToeModel() {
        newGame();
    }

    public void newGame() {
        gameState = new char[]
                {EMPTY, EMPTY, EMPTY,
                        EMPTY, EMPTY, EMPTY,
                        EMPTY, EMPTY, EMPTY};
        moveCount = 0;
    }

    /**
     * gets the value of the field at the specified index
     * @param field index of the field
     * @return the value of the field at the specified index
     */
    public char getFieldEntry(int field) {
        if(isValidFieldIndex(field))
            return gameState[field];
        else
            throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
    }

    /**
     * gets the current game state
     * @return an array representing the game state.
     */
    public char[] getGameState() {
        return gameState;
    }

    public void setGameState(char[] gameState) {
        this.gameState = gameState;
    }

    /*public char[] getBoard() {
        return gameState;
    }*/

    /**
     * checks if specified index is valid for the game field
     * @param field
     * @return @return true if the index is valid, otherwise false
     */
    public boolean isValidFieldIndex(int field) {
        return field >= 0 && field < gameState.length;
    }

    /**
     *Checks if the field at the specified index is empty
     * @param field
     ** @return true if the field is empty, otherwise false.
     */
    public boolean isEmptyField(int field) {
        if(isValidFieldIndex(field))
            return gameState[field] == EMPTY;
        else
            throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
    }

    public char getActivePlayer() {
        return (moveCount % 2 == 0) ? PLAYER_1 : PLAYER_2;
    }

    public void move(int field) {
        if(!isGameOver()) {
            if (!isValidFieldIndex(field))
                throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
            if (!isEmptyField(field))
                throw new RuntimeException("The chosen field is already taken");

            gameState[field] = getActivePlayer();
            moveCount++;

            // Print the state after the move. For easier play inside the JShell.

            System.out.println(this);
        } else
            throw new RuntimeException("The game is already over. Please start a new game.");
    }

    public boolean isGameOver()
    {
        return hasPlayer1Won() || hasPlayer2Won() || moveCount >= gameState.length;
    }

    /**
     * diese Methode return , dass der Player gewonnen hat
     * @return PLAYER1 hat gewonnen
     */
    public boolean hasPlayer1Won() {
        return checkWinCondition(PLAYER_1);
    }

    public boolean hasPlayer2Won() {
        return checkWinCondition(PLAYER_2);
    }

    private boolean checkWinCondition(char player) {
        return  // Check rows
                (gameState[0] == player && gameState[1] == player && gameState[2] == player) ||
                        (gameState[3] == player && gameState[4] == player && gameState[5] == player) ||
                        (gameState[6] == player && gameState[7] == player && gameState[8] == player) ||
                        // Check columns
                        (gameState[0] == player && gameState[3] == player && gameState[6] == player) ||
                        (gameState[1] == player && gameState[4] == player && gameState[7] == player) ||
                        (gameState[2] == player && gameState[5] == player && gameState[8] == player) ||
                        // Check diagonals
                        (gameState[0] == player && gameState[4] == player && gameState[8] == player) ||
                        (gameState[2] == player && gameState[4] == player && gameState[6] == player);
    }

    @Override
    public String toString() {
        return String.format("%s\n%c %c %c\n%c %c %c\n%c %c %c",
                isGameOver() ? "Game Over" : "Make move for "+getActivePlayer(),
                gameState[0], gameState[1], gameState[2],
                gameState[3], gameState[4], gameState[5],
                gameState[6], gameState[7], gameState[8]);
    }


}
