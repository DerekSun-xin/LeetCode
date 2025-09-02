class Solution {
    public int reverse(int x) {
        // Method 1: Can use long
        // Initialize long reverseX
        long reverseX = 0; 

        // While loop to go through each digit of x
        while (x != 0){
            reverseX = 10*reverseX + x%10;
            x/=10;  
        }

        // Judge if reverseX in range signed 32-bit integer and return accordingly. 
        if (reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)reverseX; 
        }
    }
}