class Solution {
    public int maxProfit(int[] prices) {
        int bestWithStock = Integer.MIN_VALUE, bestWithoutStock = 0;
        for( int price: prices) {
            bestWithStock = Math.max(bestWithStock, bestWithoutStock - price);
            bestWithoutStock = Math.max(bestWithoutStock, bestWithStock + price);
        }
        return bestWithoutStock;
    }
}