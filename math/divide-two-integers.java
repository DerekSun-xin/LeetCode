class Solution {
    public int divide(int dividend, int divisor) {
        // Handle Edge Case
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the quotient
        // Return sign * quotient as our final return
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = -1;
        }

        int quotient = 0;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        long remainder = absDividend;
        
        while (remainder >= absDivisor){
            int shift = 0;
            while (remainder >= absDivisor << (shift + 1)){ // pow returns double type; Need to convert to int
                shift++;
            }
            quotient += 1 << shift;
            remainder -= absDivisor << shift;
        }

        return sign * quotient;
    }
}