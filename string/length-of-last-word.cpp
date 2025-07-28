class Solution {
public:
    int lengthOfLastWord(string s) {
        int big;
        int small;
        if(s.size()==1){
            return 1;
        }
        
        for(int i=s.length()-1;i>=0;i--){
            if(s[i]==' ' && s[i-1]!=' '){
                big=i-1;
                break;
            }else if(s[i]!=' '){
                big=i;
                break;
            }   
        }
        
         for(int i=s.length()-1;i>0;i--){
            if(s[i]!=' ' && s[i-1]==' '){
                small=i;
                break;
            }    
         }
            
        
        cout<<big<<" "<<small<<endl;
        return big-small+1;
    }
};