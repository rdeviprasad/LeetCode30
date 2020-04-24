class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && nums[0] != k) return 0;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        int count = 0;
        for(int i = 1; i <=n; i++) {
            for(int j = i-1; j >=0; j--) {
                if(sum[i] - sum[j] == k) count++;
            }
        }
        
        return count;
    }
}