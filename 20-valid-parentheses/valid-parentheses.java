class Solution {
    public boolean isValid(String s) {
                // if the string is null or empty
        if (s == null || s.length() == 0) {
            return true;
        }

        // Initialize the stack and the hashmap
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if the character is an opening bracket
            if (map.containsValue(c)) {
                stack.push(c);
            }
            // if the character is a closing bracket
            else {
                // if the stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                // if the character is not the closing bracket of the opening bracket at the top
                // of the stack
                if (stack.peek() != map.get(c)) {
                    return false;
                }
                // if the character is the closing bracket of the opening bracket at the top of
                // the stack
                stack.pop();
            }
        }

        // if the stack is empty
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}