class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n == 1) return stones[n-1];
        for(int i = 0; i < n; i++) {
            Arrays.sort(stones);
            int y = stones[n-1];
            int x = stones[n-2];
            if(x == y) {
                stones[n-1] = 0;
                stones[n-2] = 0;
            } else {
                stones[n-1] = y - x;
                stones[n-2] = 0;
            }
        }
        return stones[n-1];
    }
}
