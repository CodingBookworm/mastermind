package Service;

import Model.IncorrectUserInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputService {

    public static boolean verifyInput(Object userInput, List possibleAnswers ) throws IncorrectUserInputException {
        if (!possibleAnswers.contains(userInput)){
            throw new IncorrectUserInputException("Entered invalid response! Try again!");
        }
        return true;
    }

    public static boolean verifyNoDuplicates(List<Character> list){
        Set<Character> set = new HashSet();
        if (!list.stream().allMatch(c -> set.add(c))){
            throw new IncorrectUserInputException("Duplicates are not allowed in this game!");
        };
        return true;
    }
}
