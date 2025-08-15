class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null || p.isEmpty()){
            return (s == null || s.isEmpty());
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        for (int j = 1; j < p.length(); j++){
            if (p.charAt(j-1) == '*'){
                dp[0][j]=dp[0][j-2];
            }
        }

        for(int i = 1; i < s.length(); i++){
            for(int j = 1; j < p.length(); j++){
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);
                if (pChar == '.' || pChar == sChar){
                    dp[i][j] = dp[i-1][j-1];
                }else if (pChar == '*'){
                    dp[i][j]=dp[i][j-2];
                    char prevPChar = p[j-2];
                    if (sChar == prevPChar || prevPChar == '.' ){
                        dp[i][j] = dp[i][j] || dp[i-1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }

    }
}