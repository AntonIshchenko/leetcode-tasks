import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        int resultProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            profit = prices[i] - minPrice;
            if(profit > resultProfit) {
                resultProfit = profit;
            }
        }
        return resultProfit;
    }
}
