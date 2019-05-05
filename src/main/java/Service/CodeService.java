package Service;

import Controller.UserInputController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeService {
    UserInputController userInputController = new UserInputController();

    public List<Character> setCode(String setting){
        switch (setting){
            case "secret demo":
                return Arrays.asList('A','B','E','D');
            case "user pick":
                return userInputController.getUserCode();
            default:
                return null;
        }
    }

    public List findSimilaritiesBetween(List<Character> gameCode, List<Character> userGuess) {
        List<Character> notExactMatches = new ArrayList();
        List<Character> remainingGuess = new ArrayList();
        List results = new ArrayList();

        //TODO fix for duplicates
        for (int i = 0; i < 4; i++) {
            if (userGuess.get(i).equals(gameCode.get(i))){
                results.add('*');
            }else{
                notExactMatches.add(gameCode.get(i));
                remainingGuess.add(userGuess.get(i));
            }
        }
        for (Character c: remainingGuess) {
            if (notExactMatches.contains(c)) {
                results.add('^');
                notExactMatches.remove(c);
            }
        }
//        for (int i = results.size(); i < 4; i++) {
//            results.add(' ');
//        }
        return results;
    }
}
