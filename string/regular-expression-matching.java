class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen+1][pLen+1];
        // Base Case 1
        dp[0][0] = true;
        // Base Case 2: a*;a*b* can match empty string
        for(int j=1; j<=pLen; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        for(int i=1; i<=sLen; i++){
            for(int j=1; j<=pLen; j++){
                char pChar = p.charAt(j-1);
                char sChar = s.charAt(i-1);

                if (pChar == '.' || pChar == sChar){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pChar == '*'){
                    // Case 1: * match zero of precede element
                    dp[i][j] = dp[i][j-2];

                    // Case 2: * match one or more of precede element
                    char pPrevChar = p.charAt(j-2);
                    if (pPrevChar == '.' || pPrevChar == sChar){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else{
                    dp[i][j] = false; 
                }
            }
        }

        return dp[sLen][pLen];
    }
}