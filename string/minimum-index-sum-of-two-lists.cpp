class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        vector<string> res;
        res.push_back("0");
        int indexSum = INT_MAX;
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(list1[i]==list2[j]){
                    if(i+j<indexSum){
                        res[0] = list1[i];
                        indexSum = i+j;
                    }else if(i+j==indexSum){
                        res.push_back(list1[i]);
                    }
                }
            }
        }
        return res;
    }
};