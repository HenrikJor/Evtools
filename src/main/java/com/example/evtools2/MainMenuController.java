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

    /*  old method opening a new window
        @FXML
        public void openHedgeCalculator(ActionEvent event) {
            try {
                Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/evtools2/hedgeCalc.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }

        public void openPayoutCalculator(ActionEvent event) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/evtools2/payout.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }
    */
    public void openHedgeCalculator(ActionEvent event) {
        try {
            // Load the new FXML file
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/evtools2/hedgeCalc.fxml"));

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

    public void openPayoutCalculator(ActionEvent event) {
        try {
            // Load the new FXML file
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/evtools2/payout.fxml"));

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
    public void openClvCalculator(ActionEvent event) {
        try {
            // Load the new FXML file
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/evtools2/clv.fxml"));

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

