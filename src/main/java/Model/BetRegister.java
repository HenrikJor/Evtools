package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BetRegister {
    public ObservableList<Bet> getBets() {
        return bets;
    }

    public void setBets(ObservableList<Bet> bets) {
        this.bets = bets;
    }

    private ObservableList<Bet> bets;

    public BetRegister() {
        bets = FXCollections.observableArrayList();
    }

    public void addBet(Bet bet) {
        bets.add(bet);
    }

    public void removeBet(Bet bet) {
        bets.remove(bet);
    }

public double calculateReturn() {
       double returnOnInvestmentPercentage = 0;
       double netProfit = 0;
       double turnover = 0;

        for (Bet bet : bets){
            if (bet.getOutcome() == Bet.BetOutcome.WIN) {
                netProfit += bet.getStake() * (bet.getOdds() - 1);
                turnover += bet.getStake();
            }

                else if (bet.getOutcome() == Bet.BetOutcome.LOSS) {
                netProfit -= bet.getStake();
                turnover += bet.getStake();
            }

                else {
                turnover += bet.getStake();

            }
                
                }
    returnOnInvestmentPercentage = netProfit / turnover;
    return returnOnInvestmentPercentage;
            }
        }


