package Service;

import Controller.UserInputController;
import Model.GameSettings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeService {
    UserInputController userInputController = new UserInputController();
    Random r = new Random();

    public List<Character> setCode(GameSettings settings, int currentPlayer) {
        switch (settings.getGameMode()) {
            case "Demo":
                return Arrays.asList('A', 'B', 'E', 'D');
            case "A":
                return generateRandomCode(settings.getDuplicatesAllowed());
            case "B":
                return userInputController.getSecretCode(settings.getDuplicatesAllowed(), currentPlayer);
            default:
                return null;
        }
    }

    private List<Character> generateRandomCode(Boolean duplicatesAllowed) {
        if (duplicatesAllowed){
            return IntStream
                    .generate(() -> ThreadLocalRandom.current().nextInt(6))
                    .limit(4)
                    .map(i -> i+65)
                    .mapToObj(i -> (char) i)
                    .collect(Collectors.toList());
        }
        Set<Integer> set = new HashSet<>();
        return IntStream
                .generate(() -> ThreadLocalRandom.current().nextInt(6))
                .map(i -> i+65)
                .filter(set::add) //ensures no duplicates
                .limit(4)
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());




    }

    public List findSimilaritiesBetween(List<Character> gameCode, List<Character> userGuess) {
        List<Character> notExactMatches = new ArrayList();
        List<Character> remainingGuess = new ArrayList();
        List results = new ArrayList();

        //TODO fix for duplicates
        for (int i = 0; i < 4; i++) {
            if (userGuess.get(i).equals(gameCode.get(i))) {
                results.add('*');
            } else {
                notExactMatches.add(gameCode.get(i));
                remainingGuess.add(userGuess.get(i));
            }
        }
        for (Character c : remainingGuess) {
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
