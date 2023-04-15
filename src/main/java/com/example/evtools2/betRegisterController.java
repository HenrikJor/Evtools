package com.example.evtools2;
import Model.BetRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Model.Bet;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class betRegisterController {
    @FXML
    private TextField eventTextField;

    @FXML
    private TextField selectionTextField;

    @FXML
    private TextField bookieTextField;

    @FXML
    private TextField stakeTextField;

    @FXML
    private TextField oddsTextField;

    @FXML
    private TextField returnTextField;
    @FXML
    private Button addBetButton;

    @FXML
    private TableView<Bet> betTableView;

    @FXML
    private Button winButton;

    @FXML
    private Button lossButton;

    @FXML
    private Button voidButton;

    @FXML
    private TableColumn<Bet, String> eventColumn;
    @FXML
    private TableColumn<Bet, String> selectionColumn;
    @FXML
    private TableColumn<Bet, String> bookieColumn;
    @FXML
    private TableColumn<Bet, Double> stakeColumn;
    @FXML
    private TableColumn<Bet, Double> oddsColumn;
    @FXML
    private TableColumn<Bet, String> outcomeColumn;


   private BetRegister betRegister = new BetRegister();


    @FXML
    public void initialize() {
        betTableView.setItems(betRegister.getBets());
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("event"));
        selectionColumn.setCellValueFactory(new PropertyValueFactory<>("selection"));
        bookieColumn.setCellValueFactory(new PropertyValueFactory<>("bookie"));
        stakeColumn.setCellValueFactory(new PropertyValueFactory<>("stake"));
        oddsColumn.setCellValueFactory(new PropertyValueFactory<>("odds"));
        outcomeColumn.setCellValueFactory(new PropertyValueFactory<>("outcomeString"));
        returnTextField.setText(String.valueOf(betRegister.calculateReturn()));

        betTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    @FXML
    private void addBet(ActionEvent event) {
        // Get input field values
        String eventValue = eventTextField.getText();
        String selectionValue = selectionTextField.getText();
        String bookieValue = bookieTextField.getText();
        double stakeValue = Double.parseDouble(stakeTextField.getText());
        double oddsValue = Double.parseDouble(oddsTextField.getText());

        // Create a new Bet object and add it to the bets list
        Bet newBet = new Bet(eventValue, selectionValue, bookieValue, stakeValue, oddsValue);
        betRegister.addBet(newBet);
        // Clear input fields after adding the bet
        eventTextField.clear();
        selectionTextField.clear();
        bookieTextField.clear();
        stakeTextField.clear();
        oddsTextField.clear();
        betTableView.refresh();

    }

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
    private void handleSettleButton(ActionEvent event) {
        // Get the selected bet
        Bet selectedBet = betTableView.getSelectionModel().getSelectedItem();


        // Set the bet outcome to WIN, LOSS, or VOID depending on which button was clicked
        Button button = (Button) event.getSource();
        switch (button.getId()) {
            case "winButton":
                selectedBet.setOutcome(Bet.BetOutcome.WIN);
                break;
            case "lossButton":
                selectedBet.setOutcome(Bet.BetOutcome.LOSS);
                break;
            case "voidButton":
                selectedBet.setOutcome(Bet.BetOutcome.VOID);
                break;
        }

        // Refresh the table view to show the updated outcome
        betTableView.refresh();
        returnTextField.setText(String.valueOf(betRegister.calculateReturn()));
    }
    }