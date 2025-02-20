class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                sb.append(ch);
            else if (ch == ')') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '(') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                else return false;
            } else if (ch == '}') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '{') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                else return false;
            } else if (ch == ']') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '[') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                else return false;
            }
        }
        return sb.length() == 0;
    }
}