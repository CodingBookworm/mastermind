package Controller;

import Model.GameSettings;
import Service.GameService;
import View.CommandLineViewer;
import View.Viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOrchestrator {
    private Viewer viewer = new CommandLineViewer();
    private GameService gameService = new GameService();
    private UserInputController userInputController = new UserInputController();
    private List<Integer> score = new ArrayList<>(Arrays.asList(0,0));

    public void playGame(){
        viewer.displayStart();

        //will get mode, # of rounds, and if duplicates are allowed
        GameSettings gameSettings = userInputController.getSettings();

        Integer currentPlayerNo = 0;
        for (int i = 0; i < gameSettings.getNoOfRounds(); i++) {

            //if playRound returns true, the player has won the game and their score will increase
            if (gameService.playRound(gameSettings,currentPlayerNo)){
                score.set(currentPlayerNo,score.get(currentPlayerNo)+1);
            }
            //flips player# between 0 and 1
            currentPlayerNo = 1- currentPlayerNo;

        }
        if ("B".equals(gameSettings.getGameMode())) {
            viewer.displayTextToUser("Current Score:");
            viewer.displayTextToUser("Player 1 = " + score.get(0));
            viewer.displayTextToUser("Player 2 = " + score.get(1));
        }
    }
}
