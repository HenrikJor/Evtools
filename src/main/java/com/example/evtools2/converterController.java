package com.example.evtools2;

import Model.BetCalc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class converterController {
@FXML
private TextField usOddsField;
@FXML
private TextField decimalOddsField;
@FXML
private TextField fractionalOddsField;

    private BetCalc oddsConverter = new BetCalc();



    public void openMainMenu(ActionEvent event) {
        try {
            // Load the main menu FXML file
            Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("main_menu.fxml"));

            // Get the current scene and window (stage)
            Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            // Set the main menu root as the scene's root
            currentScene.setRoot(mainMenuRoot);

            // Set the new scene on the stage
            currentStage.setScene(currentScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        usOddsField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                int usOdds = Integer.parseInt(newValue);
                double decimalOdds = oddsConverter.usToDecimal(usOdds);
                String fractionalOdds = oddsConverter.usToFractional(usOdds);
                decimalOddsField.setText(String.valueOf(decimalOdds));
                fractionalOddsField.setText(fractionalOdds);
            }
        });

        decimalOddsField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                double decimalOdds = Double.parseDouble(newValue);
                int usOdds = oddsConverter.decimalToUs(decimalOdds);
                String fractionalOdds = oddsConverter.decimalToFractional(decimalOdds);
                usOddsField.setText(String.valueOf(usOdds));
                fractionalOddsField.setText(fractionalOdds);
            }
        });

        fractionalOddsField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                String fractionalOdds = newValue;
                int usOdds = oddsConverter.fractionalToUs(fractionalOdds);
                double decimalOdds = oddsConverter.fractionalToDecimal(fractionalOdds);
                usOddsField.setText(String.valueOf(usOdds));
                decimalOddsField.setText(String.valueOf(decimalOdds));
            }
        });
    }

}
