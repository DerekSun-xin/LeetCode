class Solution {
public:
    string reverseStr(string s, int k) {
        string res = "";
        int part = 2*k;
        while(s.length()>=part){
            for(int i=0;i<k/2;i++){
                int tmp = s[i];
                s[i] = s[k-1-i];
                s[k-1-i] = tmp;
            }
            for(int i=0;i<part;i++){
                res+=s[i];
            }
            s.erase(0,part);
        }
        
    
        
        if(s.length()>=k){
            for(int i=0;i<k/2;i++){
                int tmp = s[i];
                s[i] = s[k-1-i];
                s[k-1-i] = tmp;
              //  swap[s[i]],s[k-i-1];
            }
            for(int i=0;i<k;i++){
                res+=s[i];
            }
            s.erase(0,k);
        }else{
            for(int i=0;i<s.length()/2;i++){
                int tmp = s[i];
                s[i] = s[s.length()-1-i];
                s[s.length()-1-i] = tmp;
            }
            for(int i=0;i<s.length();i++){
                res+=s[i];
            }
            s.erase(0,s.length());
           
        }
        res+=s;
        
     
        return res;
    }
};