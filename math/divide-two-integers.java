class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0; 
        }
        int quotient = 0; 
        if (dividend > 0 && divisor > 0){
            while(dividend >= 0){
                dividend-=divisor; 
                quotient++;
            }
            return quotient-1; 
        }else if (dividend < 0 && divisor < 0){
            while (dividend <= 0){
                dividend-=divisor; 
                quotient++; 
            }
            return quotient-1; 
        }else if (dividend < 0 && divisor > 0){
            while(dividend <= 0){
                dividend += divisor; 
                quotient++; 
            }
            return -(quotient-1); 
        }else if (dividend > 0 && divisor < 0){
            while(dividend >= 0){
                dividend += divisor; 
                quotient++; 
            }
            return -(quotient-1); 
        }else{
            return 0; 
        }
    }
}