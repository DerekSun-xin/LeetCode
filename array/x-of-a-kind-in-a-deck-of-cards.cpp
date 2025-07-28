class Solution {
public:
    int findGCD(int a,int b){
            if(a>=b){
                return gcd(b,a%b);
            }else{
                return gcd(a,b%a);
            }
    }
    bool hasGroupsSizeX(vector<int>& deck) {
        unordered_map<int,int> map;
        for(int i=0;i<deck.size();i++){
            if(map.find(deck[i])!=map.end()){
                map[deck[i]]++;
            }else{
                map[deck[i]]=1;
            }
        }

        int common_divisor = -1; 
        for(unordered_map<int,int>::iterator it=map.begin();it!=map.end();++it){
            if(it->second==1){
                return false;
            }

            if(common_divisor==-1){
                common_divisor = it->second;
            }else{
                common_divisor = min(common_divisor,gcd(common_divisor,it->second));
            }

        }

        return (common_divisor>=2);


        
    }
};