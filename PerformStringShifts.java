class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int[] q : shift) {
            if(q[0] == 0) {
                shiftString(0, q[1], sb);
            } else {
                shiftString(0, n - q[1], sb);
            }
        }
        return sb.toString();
    }
    
    private void shiftString(int start, int end, StringBuilder sb) {
        char[] temp = new char[end];
        sb.getChars(start, end, temp, 0);
        sb.delete(0, end);
        sb.append(temp);
    }
}