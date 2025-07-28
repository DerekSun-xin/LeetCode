class Solution {
public:
    bool isStrobogrammatic(string num) {
        unordered_map<char,char> map;
        map['9']='6';
        map['6']='9';
        map['8']='8';
        map['1']='1';
        map['0']='0';
        string comp;
        string s;
        for(int i=0;i<num.length();i++){
            if(map.find(num[i])!=map.end()){
                comp.push_back(map[num[i]]);
            }else{
                cout<<1<<endl;
                return false;
            }
        }
        string res;
        for(int i=comp.length()-1;i>=0;i--){
            res.push_back(comp[i]);
        }
        
        if(res==num){
            return true;
        }else{
            return false;
        }
    }
};