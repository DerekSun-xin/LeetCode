class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        for(int i=0;i<words.size()-1;i++){
            int j=i+1;
            if(compareWords(words[i],words[j],order)==false){
                return false;
            }
        }
        return true;
    }

    bool compareWords(string word1,string word2,string order){
        if(word1.length()<=word2.length()){
            for(int i=0;i<word1.length();i++){
                    int index1 = order.find(word1[i]);
                    int index2 = order.find(word2[i]);
                    if(index1<index2){
                        return true;
                    }else if(index1>index2){
                        return false;
                    }else{
                        //index1==index2
                        continue;
                    }
            }
            return true;
        }else{
            for(int i=0;i<word2.length();i++){
                int index1 = order.find(word1[i]);
                int index2 = order.find(word2[i]);
                if(index1<index2){
                    return true;
                }else if(index1>index2){
                    return false;
                }else{
                    continue;
                }
            }

            return false;

            
        }

        



    }
};