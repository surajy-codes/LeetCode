class Solution {
    int[][][] dp;
    int mod=1_000_000_007;
    public int findPaths(int m, int n, int max, int stR, int stC) {
        dp=new int[m+1][n+1][max+1];
        for(int i=0;i<m;i++){
            for(int[] r : dp[i]) Arrays.fill(r,-1);
        }
        int ans=f(stR,stC,m,n,max);
        return ans%mod;
    }

    int f(int i,int j,int m,int n,int max){
        if(max<0) return 0;
        if(i<0 || j<0 || i==m || j==n) return 1;
        if(dp[i][j][max]!=-1) return dp[i][j][max];
        int a=f(i+1,j,m,n,max-1);
        int b=f(i-1,j,m,n,max-1);
        int c=f(i,j+1,m,n,max-1);
        int d=f(i,j-1,m,n,max-1);
        return dp[i][j][max]=(((a+b) % mod+c) % mod+d) % mod;
    }
}