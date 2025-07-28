class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        
        int check = 1;
        
        for(int i=0;i<digits.size();i++){
           // cout<<digits[i]<<endl;
            if(digits[i]!=9){
             //   cout<<"here"<<endl;
                check = 0;
                break;
            }
        } 
        
        //cout<<check<<endl;
        if(check==1){
            //cout<<"go 1"<<endl;
            vector<int> ret;
            ret.push_back(1);
            for(int i=1;i<digits.size()+1;i++){
                ret.push_back(0);
            }
            return ret;
        }
        
        if(digits[digits.size()-1]!=9){
            digits[digits.size()-1]+=1;
        }else{
            int move = 1;
            digits[digits.size()-1]=0;
            for(int i=digits.size()-2;i>=0;i--){
                if(digits[i]!=9){
                    digits[i]+=1;
                    move=0;
                    break;
                }else{
                    digits[i]=0;
                }
            }
               
        
        }
        
        return digits;
    }
};