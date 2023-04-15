package com.example.evtools2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Model.Bet;
import javafx.scene.control.cell.PropertyValueFactory;


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
    private Button addBetButton;

    @FXML
    private TableView<Bet> betTableView;

    @FXML
    private Button settleWinButton;

    @FXML
    private Button settleLossButton;

    @FXML
    private Button settleVoidButton;

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


    private ObservableList<Bet> bets = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        betTableView.setItems(bets);
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("event"));
        selectionColumn.setCellValueFactory(new PropertyValueFactory<>("selection"));
        bookieColumn.setCellValueFactory(new PropertyValueFactory<>("bookie"));
        stakeColumn.setCellValueFactory(new PropertyValueFactory<>("stake"));
        oddsColumn.setCellValueFactory(new PropertyValueFactory<>("odds"));
        outcomeColumn.setCellValueFactory(new PropertyValueFactory<>("outcome"));
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
        bets.add(newBet);

        // Clear input fields after adding the bet
        eventTextField.clear();
        selectionTextField.clear();
        bookieTextField.clear();
        stakeTextField.clear();
        oddsTextField.clear();

        betTableView.refresh();
    }

}
