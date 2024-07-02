class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (String dir : directories) {
            if(dir.equals(".") || dir.trim().length() == 0){
                continue;
            } else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop(); // Empty the Stack
                }
            } else {
                stack.push(dir);
            }
        }
        // Stack contains the Path and needs to be converted
        for(String cpath: stack){
            sb.append("/");
            sb.append(cpath);
        }
        return sb.toString().length()>0?sb.toString():"/";
    }
}