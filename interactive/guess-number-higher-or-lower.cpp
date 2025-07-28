/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
       
        int num = 1+(n-1)/2;
        int begin = 1;
        int end = n;
        while(guess(num)!=0){
            int ret = guess(num);
            if(ret==1){
                  begin = num+1;   
            }else if(ret==-1){
              end = num-1;
            }
            
           
                 num = begin+(end-begin)/2;
            
 
        }
        
        return num;
    }
};