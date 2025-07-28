class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int count = n;
        for(int i=0;i<flowerbed.size();i++){      
            if(flowerbed[i]==0){
                if(i-1>=0){
                    //check if flowerbed[i-1] !=1
                    if(flowerbed[i-1]==1){
                        continue;
                    }
                }
                if(i+1<flowerbed.size()){
                    if(flowerbed[i+1]==1){
                        continue;
                    }
                }   
                flowerbed[i]=1;
                count--;
            }
        }
        cout<<count<<endl;
        if(count<=0){
            return true;
        }else{
            return false;
        }
    }
};