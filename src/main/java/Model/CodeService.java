package Model;

import Controller.UserInputController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List matches = new ArrayList();
        Integer place = 0;
        for (Character c: userGuess){
            if (c.equals(gameCode.get(place++))){
                matches.add('*');
            }else if (gameCode.contains(c)){
                matches.add('^');
            }
        }
        Collections.shuffle(matches);
        return matches;
    }
}
