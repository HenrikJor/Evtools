package Model;

public class HedgeBetResult {
    public double totalBetAmount;
    public double hedgeBetAmount;

    public double totalProfit;

    public double getHedgeBetAmount() {
        return hedgeBetAmount;
    }

    public void setHedgeBetAmount(double hedgeBetAmount) {
        this.hedgeBetAmount = hedgeBetAmount;
    }


    public double getTotalBetAmount() {
        return totalBetAmount;
    }

    public void setTotalBetAmount(double totalBetAmount) {
        this.totalBetAmount = totalBetAmount;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public HedgeBetResult(double totalBetAmount, double totalProfit, double hedgeBetAmount) {
        this.totalBetAmount = totalBetAmount;
        this.totalProfit = totalProfit;
        this.hedgeBetAmount = hedgeBetAmount;
    }
}