/* Solution provided by Kevin Naughton Jr. on Youtube */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int s : stones) {
            heap.add(-s);
        }
        while(heap.size() > 1) {
            int y = - heap.remove();
            int x = - heap.remove();
            if(x != y) {
                heap.add(-(y - x));
            }
        }
        
        return heap.isEmpty() ? 0 : -heap.remove();
    }
}
