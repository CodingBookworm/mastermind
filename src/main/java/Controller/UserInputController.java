package Controller;

import Model.GameSettings;
import Model.IncorrectUserInputException;
import Service.UserInputService;
import View.CommandLineViewer;
import View.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInputController {

    Scanner scanner = new Scanner(System.in);
    Viewer viewer = new CommandLineViewer();

    public GameSettings getSettings(){
        //players will choose mode, # of rounds, and if duplicates are allowed

        String mode = getUserInput("Type the corresponding letter to choose a game mode:\n"+
                "A: 1 player (computer will determine the code)\n"+
                "B: 2 player (Players will set the code or guess it on alternating games.)", Arrays.asList("A","B","Demo"));

        Integer noOfRounds = 1;

        //if there are 2 players, players choose the amount of games
        if (mode.equals("B")){
            while(true) {
                noOfRounds = Integer.parseInt(getUserInput("Enter the number of rounds you want to play\n" +
                        "(the number must be even!):"));
                if (noOfRounds % 2 == 0) {
                    break;
                }
            }
        }

        Boolean duplicatesAllowed = "Y".equals(getUserInput("Do you want the code to be able to have duplicates?\n"+
                "Enter Y or N",Arrays.asList("Y","N")));

        return GameSettings
                .builder()
                .gameMode(mode)
                .noOfRounds(noOfRounds)
                .duplicatesAllowed(duplicatesAllowed)
                .build();

    }

    public List getSecretCode(Boolean duplicatesAllowed, int currentPlayer){
        viewer.displayTextToUser("PLAYER"+(currentPlayer+1)+", ENTER YOUR CODE:");
        List code = getUserCode(duplicatesAllowed);
        getUserInput("Press ENTER to clear and pass to PLAYER"+(1-currentPlayer+1)+" to guess!");
        viewer.clearView();
        return code;
    }

    public List getUserCode(Boolean duplicatesAllowed){
        try {
            viewer.displayTextToUser("Enter 4 letters:");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() != 4) {
                throw new IncorrectUserInputException("Entered the wrong # of letters! Try again!");
            }
//        Character first = input.charAt(0);
//        Character sec = input.charAt(1);
//        Character third = input.charAt(2);
//        Character fourth = input.charAt(3);
            //return Arrays.asList(first, sec, third,fourth);
            List<Character> possibleAns = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');

            //toCharArray will return a char[], not a list!!!
            List<Character> userCode= input
                    .chars()
                    .mapToObj(c -> (char) c)
                    .filter(c ->UserInputService.verifyInput(c,possibleAns))
                    .collect(Collectors.toList());

            if(!duplicatesAllowed){
                UserInputService.verifyNoDuplicates(userCode);
            }

            return userCode;

        } catch (IncorrectUserInputException iuie) {
            System.out.println(iuie.getMessage());
            return getUserCode(duplicatesAllowed);
        }
    }
    public String getUserInput(String message){
        viewer.displayTextToUser(message);
        return scanner.nextLine().trim().toUpperCase();
    }

    //input will always be converted to uppercase
    public String getUserInput(String message, List possibleAnswers){
        try {
            viewer.displayTextToUser(message);
            String input = scanner.nextLine().trim().toUpperCase();
            UserInputService.verifyInput(input, possibleAnswers);
            return input;
        } catch (IncorrectUserInputException iuie){
            return getUserInput(iuie.getMessage(),possibleAnswers);
        }
    }
}