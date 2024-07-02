class Solution {
    public boolean backspaceCompare(String s, String t) {
        String first = remainInStack(s);
        String second = remainInStack(t);
        return first.equals(second);
    }

    String remainInStack(String str){
        StringBuilder stack = new StringBuilder();
        for(char singleChar : str.toCharArray()){
            if(singleChar != '#'){
                stack.append(singleChar); // Similar to push
            }
            else if(stack.length() > 0){
                // Backspace found
                // Remove the last inserted char
                stack.deleteCharAt(stack.length() - 1);
            }
        }
        return stack.toString(); // StringBuilder to string
    }
}