class Solution {
    private int INF = (int)1e9;
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n ; i++) {
            if(nums[i] == 0) count--;
            else count++;
            if(map.containsKey(count)) {
                ans = Math.max(ans, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return ans;
    }
}