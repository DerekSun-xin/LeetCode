class Solution {
public:
    string reverseVowels(string s) {
        vector<char> vowel {'a','e','i','o','u','A','E','I','O','U'};
        vector<int> pos;
        for(int i=0;i<s.length();i++){
            vector<char>::iterator found;
            found = find(vowel.begin(),vowel.end(),s[i]);
            if(found!=vowel.end()){
                pos.push_back(i);
            }
        }
        
        for(int i=0;i<pos.size()/2;i++){
            char tmp = s[pos[i]];
            s[pos[i]] = s[pos[pos.size()-i-1]];
            s[pos[pos.size()-i-1]] = tmp;
        }
        
        return s;
    }
};