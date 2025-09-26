class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i); 
            switch (curChar){
                case '(':
                case '{':
                case '[':
                    stack.push(curChar);
                    break;
                case ')':
                    if (stack.pop() != '('){
                        return false; 
                    }
                    break;
                case '}':
                    if (stack.pop() != '{'){
                        return false; 
                    }
                    break;
                 case ']':
                    if (stack.pop() != '['){
                        return false; 
                    }
                    break;
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false; 
        }
    }
}