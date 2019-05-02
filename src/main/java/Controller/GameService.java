package Controller;

import Model.Board;
import Model.CodeService;
import View.CommandLineViewer;
import View.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
            matches = codeService.findSimilaritiesBetween(gameCode, userGuess);
            userGuess.addAll(matches);
            rows.add(userGuess);
            if (userGuess.equals(gameCode)){
                winner = true;
                break;
            }
            viewer.displayGame(board);
            guessNo++;
        }

        if (winner){
            viewer.clearView();
            viewer.displayWin();
        }else {
            viewer.displayLose();
        }



    }

}
