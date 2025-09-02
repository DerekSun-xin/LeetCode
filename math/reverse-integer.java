class Solution {
    public int reverse(int x) {
        // Method 2: Cannot use long
        // Initialize int reverseX
        int reverseX = 0; 

        // While loop to iterate each digit of x and judge if reverseX is out of bounds
        while (x != 0){
            int pop = x % 10; // Get the last digit
            if (reverseX > Integer.MAX_VALUE / 10 || 
                (reverseX == Integer.MAX_VALUE / 10 && pop > 7)){
                    return 0; 
                }
            if (reverseX < Integer.MIN_VALUE / 10 ||
                (reverseX == Integer.MIN_VALUE / 10 && pop < -8)){
                    return 0; 
                }
            reverseX = 10* reverseX + pop; 
            x/=10; 
        }

        return reverseX; 
    }
}