class Solution {
    public boolean isValid(String s) {
        // Maintain opening closing pair
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');
        
        // Maintain a Stack
        Stack<Character> stack = new Stack<>();
        
        for (char bracket : s.toCharArray()) {
            // if opening, push in a stack
            if (pair.containsKey(bracket)) {
                stack.push(bracket);
            }
            // if closing, pop opening from the stack and compare it
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char openingBracket = stack.pop();
                char expectedClosingBracket = pair.get(openingBracket);
                if (bracket != expectedClosingBracket) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}