/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> matDimensions = binaryMatrix.dimensions();
        int m = matDimensions.get(0);
        int n = matDimensions.get(1);
        
        boolean[] candidateRows = new boolean[m];
        for(int i = 0; i < m; i++) {
            candidateRows[i] = binaryMatrix.get(i, n - 1) == 1;
        }
        
        int L = 0, R = n - 1;
        int ans = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            for(int i = 0; i < m; i++) {
                if(candidateRows[i] && binaryMatrix.get(i, mid) == 1) {
                    ans = mid;
                    R = mid - 1;
                    break;
                }
            }
            if(ans != mid) {
                L = mid + 1;
            }
        }
        
        return ans;
    }
}