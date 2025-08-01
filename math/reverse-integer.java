class Solution {
    public int reverse(int x) {
        int reversedX = 0; 
        while (x / 10 != 0 || x%10 !=0){
            if (x % 10 > 0){
                if (reversedX > Integer.MAX_VALUE/10){
                    return 0; 
                }else if(reversedX == Integer.MAX_VALUE/10 && x%10 > Integer.MAX_VALUE%10){
                    return 0; 
                }
            }else{
                if (reversedX < Integer.MIN_VALUE/10){
                    return 0;
                }else if(reversedX == Integer.MIN_VALUE/10 && x%10 < Integer.MIN_VALUE%10){
                    return 0;
                }
            }
            reversedX = reversedX* 10 + x%10;
            x = x/10;
        }
        return reversedX; 
    }
}