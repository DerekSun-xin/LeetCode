class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        unordered_map<int,int> map;

        for(int i=0;i<nums.size();i++){
           if(map.find(nums[i])!=map.end()){
               map[nums[i]]++;
           }else{
               map[nums[i]]=1;
           }
        }

        int max = 0;
        vector<int> most_frequent_ele;
        for(unordered_map<int,int>::iterator it=map.begin();it!=map.end();++it){
            if(it->second>=max){
               max = it->second;
            }
        }

        for(unordered_map<int,int>::iterator it=map.begin();it!=map.end();++it){
            if(it->second==max){
              most_frequent_ele.push_back(it->first);
            }
        }

        vector<int> shortest_length;
        for(int i=0;i<most_frequent_ele.size();i++){
           int search = most_frequent_ele[i];
           auto it = find(nums.begin(),nums.end(),search);
           int first_index = it-nums.begin();   
           vector<int>  tmp{search};
           auto last_it = find_end(nums.begin(),nums.end(),tmp.begin(),tmp.end());
           int last_index = last_it-nums.begin();
           int length = last_index-first_index+1;
           shortest_length.push_back(length);
        } 

        return *min_element(shortest_length.begin(),shortest_length.end());



    }
};