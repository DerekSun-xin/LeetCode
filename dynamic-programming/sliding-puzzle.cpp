class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        int m=board.size();     // 2
    int n=board[0].size();  // 3
    
    
    // We are not interested in processing same board again and again , which causes T.L.E for sure.
    
    set<vector<vector<int>>>st;
    
    
    // Desired board , when we get the board after several moves , we return the move count;
    
    vector<vector<int>>target={{1,2,3},
                               {4,5,0}};
    
    // Find Index of Zero that we have to change in each and every move to get different combinations.
    
    pair<int,int> zero_Index={-1,-1};
    
    for(int i=0;i<m;i++){
        
        for(int j=0;j<n;j++){
            
            if(board[i][j]==0){
                zero_Index={i,j};
                break;
            }
            
        }
        
    }
    
    
    queue<pair<vector<vector<int>>,pair<int,int>>>q;
    
    int moves=0;
    
    q.push({board,zero_Index});
    
    while(!q.empty()){
        
        int sz=q.size();
        
        while(sz--){
            
            auto curr=q.front();
            q.pop();
            
            vector<vector<int>>grid=curr.first;
            pair<int,int>index=curr.second;
            
            if(grid==target){
                return moves;
            }
            
            if(st.find(grid)!=st.end()){
                continue;
            }
            
            st.insert(grid);
            
            int i=index.first;
            int j=index.second;
            
            vector<vector<int>>temp=grid;
            
            if(i-1>=0){
                
                temp=grid;
                
                swap(temp[i-1][j],temp[i][j]);
                
                if(st.find(temp)==st.end()){
                    q.push({temp,{i-1,j}});
                }
                
            }
            
            
            if(j-1>=0){
                
                temp=grid;
                
                swap(temp[i][j-1],temp[i][j]);
                
                if(st.find(temp)==st.end()){
                    q.push({temp,{i,j-1}});
                }
                
            }
            
            
            if(i+1<m){
                
                
                temp=grid;
                
                swap(temp[i+1][j],temp[i][j]);
                
                if(st.find(temp)==st.end()){
                    q.push({temp,{i+1,j}});
                }
                
            }
            
            
            if(j+1<n){
                
                temp=grid;
                
                swap(temp[i][j+1],temp[i][j]);
                
                if(st.find(temp)==st.end()){
                    q.push({temp,{i,j+1}});
                }
                
            }
            
        }
        
        moves++;
        
    }
    
    return -1;
    
}
    
};