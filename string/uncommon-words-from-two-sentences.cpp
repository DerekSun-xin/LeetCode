class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        //vector<string> wordForSentence1;
        //vector<string> wordForSentence2;
        vector<string> ret;
        unordered_map<string,int> map1;
        string word = "";
        
        for(auto x:s1){
            if(x==' '){
                if(map1.find(word)!=map1.end()){
                    map1[word]++;
                }else{
                    map1[word]=1;
                }
                word="";
            }else{
                word+=x;
            }
        }

        if(map1.find(word)!=map1.end()){
            map1[word]++;
        }else{
            map1[word]=1;
        }

        word = "";
        for(auto x:s2){
            if(x==' '){
                if(map1.find(word)!=map1.end()){
                    map1[word]++;
                }else{
                    map1[word]=1;
                }
                word="";
            }else{
                word+=x;
            }
        }

        if(map1.find(word)!=map1.end()){
            map1[word]++;
        }else{
            map1[word]=1;
        }
    

        for(auto it=map1.begin();it!=map1.end();++it){
           
            if(it->second==1){
                ret.push_back(it->first);
            }
        }

        return ret;



        
    }
};