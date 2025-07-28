class Solution {
public:
    double myPow(double x, int n) {
        long long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        return fastPower(x,N);

    }

    double fastPower(double x,int n){
        if(n==0){
            return 1;
        }
        double half = fastPower(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
};