class Solution {
    int[][][] dp;
    public int maximumAmount(int[][] coins) {
        int n=coins.length;
        int m=coins[0].length;
        dp=new int[n][m][3];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        //tabulation, memoisation was tle, 😭
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int c = 0; c <= 2; c++) {

                    if (i == n - 1 && j == m - 1) {
                        if (coins[i][j] >= 0 || c == 0)
                            dp[i][j][c] = coins[i][j];
                        else
                            dp[i][j][c] = 0;
                        continue;
                    }

                    int down = (i + 1 < n) ? dp[i + 1][j][c] : (int)-1e9;
                    int right = (j + 1 < m) ? dp[i][j + 1][c] : (int)-1e9;

                    if (coins[i][j] >= 0 || c == 0) {
                        dp[i][j][c] = coins[i][j] + Math.max(down, right);
                    } else {
                        int downSkip = (i + 1 < n) ? dp[i + 1][j][c - 1] : (int)-1e9;
                        int rightSkip = (j + 1 < m) ? dp[i][j + 1][c - 1] : (int)-1e9;

                        int skip = Math.max(downSkip, rightSkip);
                        int take = coins[i][j] + Math.max(down, right);

                        dp[i][j][c] = Math.max(skip, take);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
    int f(int i,int j, int c,int[][] coins){
        if(i==coins.length-1 && j==coins[0].length-1){
            if(coins[i][j]>=0 || c==0) return coins[i][j];
            return 0;
        }
        if(i<0 || j<0 || i>=coins.length || j>=coins[0].length) return (int)-1e9;;
        if(dp[i][j][c]!=-1) return dp[i][j][c];
        int ans=0;

        int a=f(i+1,j,c,coins);
        int b=f(i,j+1,c,coins);

        if(coins[i][j]>=0 || c==0){
            ans=coins[i][j]+Math.max(a,b);
        }else{
            
            ans=Math.max(f(i+1,j,c-1,coins),f(i,j+1,c-1,coins));

            //we can also take negative, there can be chance,
            ans=Math.max(ans,coins[i][j]+Math.max(a,b));
        }
        return dp[i][j][c]=ans;
    }

}