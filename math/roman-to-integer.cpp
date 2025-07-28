class Solution {
public:
    
    int romanToInt(string s) {
        map<string,int> Roman;
        Roman["IV"]=4;
        Roman["IX"]=9;
        Roman["XL"]=40;
        Roman["XC"]=90;
        Roman["CD"]=400;
        Roman["CM"]=900;
        
        int sum=0;
        for(map<string,int>::iterator it=Roman.begin();it!=Roman.end();++it){
            if(s.find(it->first)!=-1){
                sum+=it->second;
                cout<<it->second<<endl;
                int pos=s.find(it->first);
                s.erase(pos,2);
                cout<<s<<endl;
            }
        }
        cout<<s<<endl;
        
        map<char,int> Normal;
        Normal['I']=1;
        Normal['V']=5;
        Normal['X']=10;
        Normal['L']=50;
        Normal['C']=100;
        Normal['D']=500;
        Normal['M']=1000;
        for(int i=0;i<s.length();i++){
            sum+=Normal[s[i]];
        }
        return sum;
    }
};