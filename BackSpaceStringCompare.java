class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = getCharStack(S);
        Stack<Character> tStack = getCharStack(T);
        return sStack.equals(tStack);
    }

    private Stack<Character> getCharStack(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '#') {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(S.charAt(i));
            }
        }
        return stack;
    }
}