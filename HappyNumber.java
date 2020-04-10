class Solution {

    private int process(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += (digit * digit);
        }

        return sum;
    }
    public boolean isHappy(int n) {
        Map<Integer, Boolean> visited = new HashMap<>();
        while(true) {
            n = process(n);
            if(n == 1) return true;
            if(visited.get(n) != null && visited.get(n)) {
                return false;
            } else {
                visited.put(n, true);
            }
        }
    }
}