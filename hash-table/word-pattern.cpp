class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map<char,string> map;
        vector<string> words;
        string word = "";
        unordered_map<string,char> map2;
        
        for(int i=0;i<s.length();i++){
            if(s[i] ==' '){
                //cout<<word<<endl;
                words.push_back(word);
                word = "";
            }else if(i==s.length()-1){
                word = word+s[i];
               // cout<<word<<endl;
                words.push_back(word);
            }else{
                word = word+s[i];   
            }  
        }
        
        if(pattern.length()!=words.size()){
           //cout<<pattern.length()<<" "<<words.size()<<endl;
            return false;
        }
        
        for(int i=0;i<pattern.length();i++){
            if(i<words.size()){
                if(map.find(pattern[i])!=map.end()){
                    if(map[pattern[i]]==words[i]){
                        continue;
                    }else{
                        return false;
                    }
                }else{
                    if(map2.find(words[i])!=map2.end()){
                      if(pattern[i]!=map2[words[i]]){
                          return false;
                      }  
                    }else{
                        map[pattern[i]]=words[i];
                        map2[words[i]]=pattern[i];
                    }
                  
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
};