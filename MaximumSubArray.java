class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int num : nums) {
            currentSum += num;
            bestSum = Math.max(bestSum, currentSum);
            currentSum = Math.max(0, currentSum);
        }
        return bestSum;
    }
}