class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] outputArr = new int[n];
        Arrays.fill(outputArr, 0);
        int total = 1;
        for(int i = 0; i < n; i++) {
            outputArr[i] = total;
            total *= nums[i];
        }
        total = nums[n-1];
        for(int i = n - 2; i >= 0; i--) {
            outputArr[i] *= total;
            total *= nums[i];
        }
        
        return outputArr;
    }
}