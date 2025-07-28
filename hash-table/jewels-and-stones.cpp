class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        vector<char> jewel;
        for(int i=0;i<jewels.length();i++){
            jewel.push_back(jewels[i]);
        }

        int ret = 0;
        for(int i=0;i<stones.length();i++){
            if(find(jewel.begin(),jewel.end(),stones[i])!=jewel.end()){
                ret++;
            }
        }

        return ret;
    }
};