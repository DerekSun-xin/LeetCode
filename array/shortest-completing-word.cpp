class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        unordered_map<char,int> map1;
        
        for(int i=0;i<licensePlate.length();i++){
            if(isalpha(licensePlate[i])){
               // cout<<licensePlate[i]<<endl;
                if(map1.find(tolower(licensePlate[i]))!=map1.end()){
                    map1[tolower(licensePlate[i])]++;
                }else{
                    map1[tolower(licensePlate[i])]=1;
                }
            }
        }

        int size = INT_MAX;
        string ret;
        for(int i=0;i<words.size();i++){
            if(words[i].size()<size){

                unordered_map<char,int> map2;
                for(int j=0;j<words[i].length();j++){
                    if(map2.find(words[i][j])!=map2.end()){
                        map2[words[i][j]]++;
                    }else{
                        map2[words[i][j]]=1;
                    }
                }

                bool check = true;
                //Check whether words[i] is qualified
                for(auto it=map1.begin();it!=map1.end();++it){
                    if(map2.find(it->first)!=map2.end() && map2[it->first]>=it->second){
                        continue;
                    }else{
                        check = false;
                        break;
                    }
                
                }

                if(check==true){
                    ret = words[i];
                    size = words[i].size();
                }
            }
        }

        return ret;
    
    }
};