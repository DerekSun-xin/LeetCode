class Solution {
public:
    string reverseWords(string s) {
        string res = "";
        vector<string> vec;
        string word = "";
        for(auto x:s){
            if(x==' '){
              //  cout<<word<<endl;
                vec.push_back(word);
                word="";
            }else{
                word = word+x;
            }
        }
        vec.push_back(word);
        
        for(int i=0;i<vec.size();i++){
            reverse(vec[i]);
        }
        
        for(int i=0;i<vec.size();i++){
           if(i!=vec.size()-1){
               res+=vec[i]+" ";
           }else{
               res+=vec[i];
           }
        }
        
        return res;
    }
    
    void reverse(string& s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            swap(s[i],s[n-i-1]);
        }
    }
};