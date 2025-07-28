class TwoSum {
public:
    unordered_map<long long int,int> twoSum;
    
    TwoSum() {
        unordered_map<long long int,int> twoSum;
        this->twoSum = twoSum;
    }
    
    void add(int number) {
        if(this->twoSum.find(number)!=this->twoSum.end()){
            this->twoSum[number]++;
        }else{
            twoSum[number]=1;
        }
    }
    
    bool find(int value) {
        unordered_map<long long int,int>:: iterator itr;
        for(itr = this->twoSum.begin();itr!=this->twoSum.end();itr++){
            long long int val = itr->first;
            long long int comp = value-val;
            if(val!=comp){
                if(this->twoSum.find(comp)!=this->twoSum.end()){
                    return true;
                }
            }else{
                if(twoSum[val]>1){
                    return true;
                }
            }
        }
        return false;

    }
};

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum* obj = new TwoSum();
 * obj->add(number);
 * bool param_2 = obj->find(value);
 */