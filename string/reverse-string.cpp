class Solution {
public:
    void reverseString(vector<char>& s) {
        int time;
        time = s.size()/2;
        char tmp;
        for(int i=0;i<time;i++){
            tmp = s[i];
            int end = s.size()-1-i;
            s[i] = s[end];
            s[end] = tmp;
        }
        
    }
};