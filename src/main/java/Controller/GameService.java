package Controller;

import Model.CodeService;

import java.util.List;

public class GameService {
    CodeService codeService = new CodeService();

    public void playGame(){
        List<Character> gameCode = codeService.setCode("secret demo");
        List userGuess;
            userGuess = codeService.setCode("user pick");
            codeService.findSimilaritiesBetween(gameCode, userGuess);


    }

}
