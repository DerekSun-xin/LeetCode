class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
       vector<int> vec;
        vec = score;
       vector<string> res;
       sort(vec.begin(),vec.end(),greater<int>());
       unordered_map<int,string> map1;
       for(int i=0;i<vec.size();i++){
          
           if(i==0){
               map1[vec[i]] = "Gold Medal";
           }else if(i==1){
               map1[vec[i]] = "Silver Medal";
           }else if(i==2){
               map1[vec[i]] = "Bronze Medal";
           }else{
               map1[vec[i]] = to_string(i+1);
           }
       }
        
        
        for(int i=0;i<score.size();i++){
            if(map1.find(score[i])!=map1.end()){
                  res.push_back(map1[score[i]]);
            }
        }
        
        return res;
    }
};