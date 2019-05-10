package Service;

import Controller.UserInputController;
import Model.Board;
import Model.GameSettings;
import View.CommandLineViewer;
import View.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameService {

    CodeService codeService = new CodeService();
    Viewer viewer = new CommandLineViewer();
    UserInputController userInputController = new UserInputController();

    public boolean playRound(GameSettings gameSettings, int currentPlayer){
        List<Character> gameCode = codeService.setCode(gameSettings, currentPlayer);
        List matches;
        List userGuess;
        int guessNo =0;
        boolean winner = false;
        Board board = new Board();
        List rows = board.getRows();


        while (guessNo < 20) {
            userGuess = userInputController.getUserCode(gameSettings.getDuplicatesAllowed());
            if (userGuess.equals(gameCode)){
                winner = true;
                break;
            }
            matches = codeService.findSimilaritiesBetween(gameCode, userGuess);
            List<Character> newRow = new ArrayList<>(userGuess);
            newRow.addAll(matches);
            rows.add(newRow);

            viewer.displayBoard(board);
            guessNo++;
        }

        if (winner){
            viewer.displayWin(guessNo);
            return true;
        }
        viewer.displayLose();
        return false;




    }
}
