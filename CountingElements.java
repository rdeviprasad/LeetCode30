class Solution {
    public int countElements(int[] arr) {
        if(arr.length == 1) {
            return 0;
        }

        int[] counter = new int[1001];
        Arrays.fill(counter, 0);

        for(int x : arr) {
            counter[x]++;
        }
        int count = 0;
        for(int i = 0; i < 1001; i++) {
            if(i + 1 == 1001 || counter[i+1] == 0) continue;
            if(counter[i] > 0 && counter[i+1] > 0)
                count += counter[i];
        }
        return count;
    }
}