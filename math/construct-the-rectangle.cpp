class Solution {
public:
    vector<int> constructRectangle(int area) {
        vector<vector<int> > res;
        int diff = INT_MAX;
        for(int i=area;i>0;i--){
            if(area%i==0){
                int small = area/i;
                int difference = abs(i-small);
                if(difference<diff){
                    diff = difference;
                    vector<int> vec {i,small};
                    res.push_back(vec);
                }
                
            }
            
        }
        return res[res.size()-1];
    }
};