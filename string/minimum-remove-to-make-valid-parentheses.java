class Solution {
    public String minRemoveToMakeValid(String s){
        Stack<Integer> stack = new Stack<>();
        // Use a StringBuilder for efficient string manipulation
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<sb.length();i++){
            if (sb.charAt(i) == '('){
                stack.push(i);
            }else if(sb.charAt(i) == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                }else{
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }

        while(!stack.isEmpty()){
            // We want to delete starting from the last inded of stack
            int lastIndex = stack.pop();
            sb.deleteCharAt(lastIndex);
        }

        return sb.toString();
    }
}