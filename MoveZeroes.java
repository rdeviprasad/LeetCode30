class Solution {
    public void moveZeroes(int[] nums) {
        int next = 0;
        for(int n : nums) {
            if(n != 0) {
                nums[next++] = n;
            }
        }
        while(next < nums.length) {
            nums[next++] = 0;
        }
    }
}