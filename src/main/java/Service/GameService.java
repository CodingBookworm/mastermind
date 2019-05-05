package Service;

import Controller.UserInputController;
import Model.Board;
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

    public void playGame(){
        List<Character> gameCode = codeService.setCode("secret demo");
        List matches;
        List userGuess;
        int guessNo =0;
        boolean winner = false;
        Board board = new Board();
        List rows = board.getRows();


        while (guessNo < 20) {
            userGuess = userInputController.getUserCode();
            if (userGuess.equals(gameCode)){
                winner = true;
                break;
            }
            matches = codeService.findSimilaritiesBetween(gameCode, userGuess);
            List<Character> newRow = new ArrayList<>(userGuess);
            newRow.addAll(matches);
            rows.add(newRow);

            viewer.displayGame(board);
            guessNo++;
        }

        if (winner){
            viewer.displayWin(guessNo);
        }else {
            viewer.displayLose();
        }



    }

}
