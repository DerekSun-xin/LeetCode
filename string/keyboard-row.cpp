class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        vector<string> res;
        unordered_map<char,int> map1;
        vector<int> vec1 {'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'};
        vector<int> vec2 {'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'};
        vector<int> vec3 {'z','x','c','v','b','n','m','Z','X','C','V','B','N','M'};
        
        vector<int>::iterator it;
        vector<int> theVec;
        bool adjust = false;
        bool correct = false;
        for(int i=0;i<words.size();i++){
            adjust = false;
            correct = false;
            for(int j=0;j<words[i].length();j++){
                if(adjust==false){
                    if(find(vec1.begin(),vec1.end(),words[i][j]) !=vec1.end()){
                        theVec = vec1;
                       // cout<<"1"<<endl;
                    }else if(find(vec2.begin(),vec2.end(),words[i][j])!=vec2.end()){
                        theVec = vec2;
                      //  cout<<"2"<<endl;
                    }else{
                        theVec = vec3;
                      //  cout<<"3"<<endl;
                    }
                    adjust = true;
                   
                }
                
                if(find(theVec.begin(),theVec.end(),words[i][j])!=theVec.end()){
                    if(j==words[i].length()-1){
                        res.push_back(words[i]);
                    }else{
                        continue;
                    }
                   
                }else{
                    break;
                }
                
            }
        }
        return res;
    }
};