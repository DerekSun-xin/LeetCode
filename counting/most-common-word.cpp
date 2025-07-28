class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        unordered_map<string,int> map1;
        
        string word="";

        for(int i=0;i<paragraph.length();i++){
            if(isalpha(paragraph[i])){
                word+=tolower(paragraph[i]);
            }else{
                if(word!=""){
                    if(map1.find(word)!=map1.end()){
                        map1[word]++;
                    }else{
                        map1[word]=1;
                        }       
                }
                
                word="";
            }
        }

        if(word!=""){
            if(map1.find(word)!=map1.end()){
                map1[word]++;
            }else{
                map1[word]=1;
            }
        }
        

        for(auto it=map1.begin();it!=map1.end();++it){
            cout<<it->first<<" "<<it->second<<endl;
        }


        for(int i=0;i<banned.size();i++){
            string ban = banned[i];
            map1.erase(ban);
        }

        int mostFrequentWord = 0;
        string ret;
        for(auto it=map1.begin();it!=map1.end();++it){
            if(it->second>mostFrequentWord){
                ret = it->first;
                mostFrequentWord = it->second;
            }
        }

        return ret;

    }
};