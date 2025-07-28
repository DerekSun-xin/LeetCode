class Solution {
public:
    bool areSentencesSimilar(vector<string>& sentence1, vector<string>& sentence2, vector<vector<string>>& similarPairs) {
        if(sentence1.size()!=sentence2.size()){
            return false;
        }

        unordered_map<string,vector<string> > map1;
        for(int i=0;i<similarPairs.size();i++){
            vector<string> element = similarPairs[i];
            map1[element[0]].push_back(element[1]);
            map1[element[1]].push_back(element[0]);
        }

        for(int i=0;i<sentence1.size();i++){
            if(find(map1[sentence1[i]].begin(),map1[sentence1[i]].end(),sentence2[i])==map1[sentence1[i]].end() && find(map1[sentence2[i]].begin(),map1[sentence2[i]].end(),sentence1[i])==map1[sentence2[i]].end() && sentence1[i]!=sentence2[i]){
                return false;
            }
        }

        return true;
    }
};