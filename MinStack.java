class MinStack {
    private class StackNode {
        int data;
        int currMin;
        StackNode next;
        public StackNode() {
            currMin = Integer.MAX_VALUE;
        }
    }
    StackNode top;
    /** initialize your data structure here. */
    public MinStack() {
        top = new StackNode();
    }

    public void push(int x) {
        StackNode newElement = new StackNode();
        newElement.data = x;
        if(top != null) {
            newElement.currMin = Math.min(top.currMin, x);
        } else {
            newElement.currMin = x;
        }
        newElement.next = top;
        top = newElement;
    }

    public void pop() {
        if(top != null) {
            top = top.next;
        }
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return top.currMin;
    }
}