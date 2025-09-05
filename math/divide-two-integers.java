class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE; 
        }
        // Determine the sign of the quotient
        // Return sign * quotient in the end
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = -1; 
        }
        int quotient = 0;
        long absDividend = Math.abs(dividend); 
        long absDivisor = Math.abs(divisor); 
        long remainder = absDividend; 

        while (remainder >= absDivisor){
            int shift = 0;
            while(remainder > absDivisor * (int) Math.pow(2,shift+1)){
                shift++; 
            }
            quotient += (int) Math.pow(2,shift); 
            remainder -= absDivisor * (int) Math.pow(2,shift); 
        }
        return sign * quotient; 
    }
}