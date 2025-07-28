class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        //check if legal
        int multiply = mat.size() * mat[0].size();
        if(r*c != multiply){
            return mat;
        }
        
        vector<int> sum;
        int matC = mat[0].size();
        for(int i=0;i<mat.size();i++){
            for(int j=0;j<matC;j++){
                sum.push_back(mat[i][j]);
            }
        }
        
        vector<vector<int>> res;
        
        vector<int> pull;
        for(int i=0;i<c;i++){
            pull.push_back(0);
        }
        for(int i=0;i<r;i++){
            res.push_back(pull);
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){      
                int index = c*i+j;
                res[i][j] = sum[index];
                
            }
        }
        
        return res;
    }
};