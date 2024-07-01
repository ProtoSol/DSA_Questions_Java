class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder ns = new StringBuilder();
        while (!stack.isEmpty()) {
            ns.append(stack.pop());
        }
        return ns.reverse().toString();
    }
}