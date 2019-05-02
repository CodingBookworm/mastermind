package Controller;

import View.CommandLineViewer;
import View.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        viewer.displayTextToUser("Enter 4 letters:");
        String input = scanner.nextLine().toUpperCase();
        //TODO check for invalid input
//        Character first = input.charAt(0);
//        Character sec = input.charAt(1);
//        Character third = input.charAt(2);
//        Character fourth = input.charAt(3);
        //return Arrays.asList(first, sec, third,fourth);
        return input
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}
