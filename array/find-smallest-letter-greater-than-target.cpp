class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int left = 0;
        int right = letters.size()-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(target>=letters[mid]){
                left = mid+1;
            }else{
                //Target<letters[mid]
                if(mid-1>=0){
                    if(letters[mid-1]<=target){
                        return letters[mid];
                    }else{
                        right = mid-1;
                    }
                }else{
                    return letters[0];
                }
                
            }

        }

        return letters[0];
    }

    

};