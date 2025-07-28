class Solution {
public:
   
    int findClosest(int num,vector<int> vec){
        for(int i=0;i<vec.size();i++){
            if(num>=vec[i]){
                return vec[i];
            }     
        }
        return vec[vec.size()-1];
    }

    string intToRoman(int num) {
        unordered_map<int,string> map1;
        map1[1]="I";
        map1[5]="V";
        map1[10]="X";
        map1[50]="L";
        map1[100]="C";
        map1[500]="D";
        map1[1000]="M";
        map1[4] ="IV";
        map1[9] = "IX";
        map1[40] = "XL";
        map1[90] = "XC";
        map1[400] = "CD";
        map1[900] = "CM";

        string ret = "";
        unsigned int value = num;
        vector<int> vec{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        sort(vec.begin(),vec.end(),greater<int>());
       
        
        while(value!=0){
            unsigned int closest = findClosest(value,vec);
            ret+=map1[closest];
            value-=closest;
        }
        

        return ret;

        
    }
};