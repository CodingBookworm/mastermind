package Controller;

import Model.IncorrectUserInputException;
import View.CommandLineViewer;
import View.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TODO ask why builder is necessary

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInputController {

    Scanner scanner = new Scanner(System.in);
    Viewer viewer = new CommandLineViewer();

    public List getUserCode(){
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
            List<Character> userCode= input
                    .chars()
                    .mapToObj(c -> (char) c)
                    .filter(possibleAns::contains)
                    .collect(Collectors.toList());
            //toCharArray will return a char[], not a list!!!

            if (userCode.size()!= 4) {
                throw new IncorrectUserInputException("Entered invalid character! Try again!");
            }

            return userCode;

        } catch (IncorrectUserInputException iuie) {
            System.out.println(iuie.getMessage());
            return getUserCode();
        }
    }
}