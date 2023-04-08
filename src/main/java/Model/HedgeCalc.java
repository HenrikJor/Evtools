package Model;

public class HedgeCalc {
    public static HedgeBetResult hedgeBet(double originalBetAmount, double originalOdds, double hedgeOdds) {
        // Calculate the potential win amount of the original bet
        double originalWinAmount = originalBetAmount * originalOdds;

        // Calculate the required hedge bet amount based on the original win amount and hedge odds
        double hedgeBetAmount = originalWinAmount / hedgeOdds;

        // Calculate the profit if the original bet wins
        double originalBetProfit = originalWinAmount - originalBetAmount - hedgeBetAmount;

        // Calculate the profit if the hedge bet wins
        double hedgeBetProfit = hedgeBetAmount * hedgeOdds - originalBetAmount;

        // The total profit should be the same (or very close) for both outcomes
        double totalProfit = Math.min(originalBetProfit, hedgeBetProfit);

        // Return the result as a Model.HedgeBetResult object
        return new HedgeBetResult(originalBetAmount + hedgeBetAmount, totalProfit, hedgeBetAmount);
    }


    /**
     * Calculates the bookmaker's margin for a series of bets with given decimal odds.
     *
     * @param decimalOdds The decimal odds for every possible outcome of an event
     * @return The bookmaker's payout percentage as a double
     */
    public static double calculatePayoutPercentage(double... decimalOdds) {
        double totalImpliedProbability = 0.0;

        for (double odd : decimalOdds) {
            totalImpliedProbability += (1 / odd) * 100;
        }

        double payoutPercentage = 100 / totalImpliedProbability * 100;
        return payoutPercentage;
    }


    /**
     * Calculates the bookmaker's margin for a series of bets with given decimal odds.
     *
     * @param correctOdds The predicted or known odds corresponding to the true probability of an event
     * @return The predicted or known value of a bet expressed as a percentage
     */
    public static double calculateCLV(double placedOdds, double correctOdds) {
        // Calculates the percentage value of a bet based on the placed and correct odds
        double clv = ((((placedOdds / correctOdds) - 1)) *100);
        return clv;
    }
// method for converting odds types : 
}