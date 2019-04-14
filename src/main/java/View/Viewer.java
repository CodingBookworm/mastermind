package View;

import Model.Board;

import java.util.List;

public interface Viewer {
    void displayStart();
    void displayTextToUser(String message);
    String getUserInput();
    List<Character> getUserCode();
    void displayGame(Board board);
    void clearView();
    void displayWin();
    void displayLose();
}
