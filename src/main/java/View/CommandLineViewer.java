package View;

import Model.Board;

import java.util.List;

public class CommandLineViewer implements Viewer {
    @Override
    public void displayStart() {

    }

    @Override
    public void displayTextToUser(String message) {
        System.out.println(message);
    }


    @Override
    public void displayGame(Board board) {
        clearView();
        for (List<Character> row : board.getRows()){
            for (char c: row){
                System.out.print(c+" ");
            }
            System.out.println();
//            System.out.printf("%c %c %c %c      %c %c %c %c\n",
//                    row.get(0), row.get(1), row.get(2), row.get(3), //letters
//                    row.get(4), row.get(5), row.get(6), row.get(7) //symbols
//            );
        }

    }

    @Override
    public void clearView() {
        //TODO figure out how to clear window console
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            line.append("\n");
        }
        System.out.println(line);

    }

    @Override
    public void displayWin() {
        System.out.println("YOU WON!!");

    }

    @Override
    public void displayLose() {
        System.out.println("YOU LOST!");

    }



    }
