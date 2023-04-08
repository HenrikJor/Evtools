package com.example.evtools2;

import Model.HedgeCalc;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;



public class clvController {

    @FXML
    private Button backButton;

    @FXML
    private TextField yourOddsTextField;

    @FXML
    private TextField correctOddsTextField;

    @FXML
    private TextField ClvTextField;

    private HedgeCalc hedgeCalc = new HedgeCalc();

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

    private void updateOutputFields() {
        try {
            double odds = Double.parseDouble(yourOddsTextField.getText());
            double correctOdds = Double.parseDouble(correctOddsTextField.getText());
            double clv = hedgeCalc.calculateCLV(odds, correctOdds);
            ClvTextField.setText(String.format("%.2f", clv));
        } catch (NumberFormatException e) {
            // Handle the exception if the input is not a number
        }
    }

    public void initialize() {
        ChangeListener<String> inputChangeListener = (observable, oldValue, newValue) -> updateOutputFields();
        yourOddsTextField.textProperty().addListener(inputChangeListener);
        correctOddsTextField.textProperty().addListener(inputChangeListener);
    }
}

