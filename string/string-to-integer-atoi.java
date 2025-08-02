class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int curInt = 0; 
        boolean isLeadZero = true; 
        boolean isLeadSign = true; 
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i); 
            int digit = curChar - '0'; 
            if (curChar == ' '){
                continue;
            }
            if (curChar == '-' && isLeadSign){
                isLeadSign = false; 
                sign = -1;
                continue; 
            }else if(curChar == '-'){
                break; 
            }
            if (curChar == '+' && isLeadSign){
                isLeadSign = false; 
                continue; 
            }else if(curChar == '+'){
                break; 
            }
            if (!Character.isDigit(curChar)){
                break; 
            }
            if(digit == 0 && isLeadZero){
                isLeadZero = false; 
                isLeadSign = false;
                continue; 
            }
            isLeadSign = false;
            if (sign == 1){
                if (curInt > Integer.MAX_VALUE/10){
                    return Integer.MAX_VALUE;
                }else if (curInt == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10){
                    return Integer.MAX_VALUE; 
                }
                curInt = curInt * 10 + digit; 
            }else{
                if(curInt > 0){
                    curInt = sign * curInt; 
                }
                if (curInt < Integer.MIN_VALUE/10){
                    return Integer.MIN_VALUE;
                }else if(curInt == Integer.MIN_VALUE/10 && digit < Integer.MIN_VALUE % 10){
                    return Integer.MIN_VALUE;
                }
                curInt = curInt * 10 - digit; 
            }
        }
        return curInt; 
    }
}