class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> map1;
       
        
        for(int i = 0;i<s.length();i++){
             if(map1.find(s[i])!=map1.end()){
                 map1[s[i]]++;
             }else{
                 map1[s[i]]=1;
             }
        }
        
        bool checkOdd = 0;
        int oddCount = 0;
        int length = 0;
        vector<int> odd;
        for(auto x:map1){
            if(x.second%2==0){
                length+=x.second;
            }else{
                checkOdd = 1;
                int add = x.second-1;
                length+=add;
               // cout<<x.second<<endl;
            }
        }
        
        if(checkOdd == true){
            return 1+length;
        }else{
            return length;
              }
        

        
        
        
        
        
        
        
        
    }
};