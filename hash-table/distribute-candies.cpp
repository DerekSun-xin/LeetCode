class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        int n = candyType.size();
        unordered_map<int,int> map1;
        for(int i=0;i<n;i++){
            if(map1.find(candyType[i])!=map1.end()){
                map1[candyType[i]]++;
            }else{
                map1[candyType[i]] = 1;
            }
        }
        
        int count = n/2;
        int type = 0;
        
        for(auto x:map1){
            if(count>0){
                type++;
                count--;
            }
        }
        
        return type;
        
        
    }
};