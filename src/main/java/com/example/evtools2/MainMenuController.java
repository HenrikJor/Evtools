package com.example.evtools2;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;



public class MainMenuController {
    public MainMenuController() {
    }


    public void openHedgeCalculator(ActionEvent event) {
        changeScene(event, "/com/example/evtools2/hedgeCalc.fxml");
    }

    public void openPayoutCalculator(ActionEvent event) {
        changeScene(event, "/com/example/evtools2/payout.fxml");
    }

    public void openClvCalculator(ActionEvent event) {
        changeScene(event, "/com/example/evtools2/clv.fxml");
    }

    public void openConverter(ActionEvent event) {
        changeScene(event, "/com/example/evtools2/converter.fxml");
    }

    private void changeScene(ActionEvent event, String fxmlPath) {
        try {
            // Load the new FXML file
            Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlPath));

            // Get the current scene and window (stage)
            Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            // Set the new root as the scene's root
            currentScene.setRoot(newRoot);

            // Set the new scene on the stage
            currentStage.setScene(currentScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
