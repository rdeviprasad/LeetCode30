class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int partition = findInflexion(nums);
        if (partition == -1)
            return binarySearch(nums, 0, n - 1, target);
        return Math.max(binarySearch(nums, 0, partition - 1, target), binarySearch(nums, partition, n - 1, target));
    }
    
    private int findInflexion(int[] nums) {
        if(nums[0] < nums[nums.length - 1]) return -1;
        int ans = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[nums.length - 1]) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
    
    private int binarySearch(int[] nums, int l, int r, int t) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == t) return mid;
            if(nums[mid] > t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}