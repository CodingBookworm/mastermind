package Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputController {

    public List getUserCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a char");
        Character first = scanner.next().charAt(0);
        Character sec = scanner.next().charAt(0);
        Character third = scanner.next().charAt(0);
        Character fourth = scanner.next().charAt(0);
        return Arrays.asList(first, sec, third,fourth);
    }
}
