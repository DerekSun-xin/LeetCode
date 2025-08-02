class Solution {
    public int myAtoi(String s) {
        // 1. Initialize all variables 
        int index = 0; 
        int sign = 1; 
        int result = 0; 
        int n = s.length(); 
        if (n == 0){
            return 0; 
        }

        // 2. Filter out all whitespaces
        while (index < n && s.charAt(index) == ' '){
            index++; 
        }

        // 3. Determine the sign
        if(index < n & (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = s.charAt(index) == '+' ? 1: -1; 
            index++; 
        }

        // 4. Deal with digit
        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0'; 
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)){
                return sign == 1?Integer.MAX_VALUE: Integer.MIN_VALUE; 
            }
            result = result*10 + digit; 
            index++; 
        }
        return sign * result; 
    }
}