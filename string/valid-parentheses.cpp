#include <string.h>
#include <stdio.h>

class Solution {
public:
    bool isValid(string s) {
        if(s.length()==1){
            return false;
        }
        map<char,char> mymap;
        mymap['[']=']';
        mymap['(']=')';
        mymap['{']='}';
        stack<char> mystack;
        
        for(int i=0;i<s.length();i++){
            if(s[i]=='[' || s[i]=='(' || s[i]=='{'){
                mystack.push(s[i]);
            }else{
                if(mystack.size()!= 0 && s[i]==mymap[mystack.top()]){
                    mystack.pop();
                }else{
                    return false;
                }
            }
        }
        
        if(mystack.empty()){
            return true;
        }else{
            return false;
        }
        
    }
};