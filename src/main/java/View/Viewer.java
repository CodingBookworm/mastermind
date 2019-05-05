package View;

import Model.Board;

public interface Viewer {
    void displayStart();
    void displayTextToUser(String message);
    void displayGame(Board board);
    void clearView();
    void displayWin(int guesses);
    void displayLose();
}
