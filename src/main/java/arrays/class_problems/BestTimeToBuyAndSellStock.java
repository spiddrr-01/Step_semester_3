package arrays.class_problems;

/**
 * Week 4 - Category C - L2: Best Time to Buy and Sell Stock
 *
 * One left-to-right pass tracking the lowest price seen so far and the largest
 * profit achievable by selling on the current day. Returns 0 when prices only
 * ever fall, since no trade would be profitable.
 */
public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int lowestSoFar = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestSoFar;
            if (profitIfSoldToday > bestProfit) {
                bestProfit = profitIfSoldToday;
            }
            if (prices[i] < lowestSoFar) {
                lowestSoFar = prices[i]; // a new cheapest buy-in for later days
            }
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
    }
}
