class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int n=pairs.length;
        int[][] dp=new int[n][n+1];
        for(int[] i : dp) Arrays.fill(i,-1);
        int ans=f(0,-1,pairs,dp);
        return ans;
    }
    int f(int idx,int prev,int[][] pairs,int[][] dp){
        if(idx==pairs.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int p=0;
        if(prev==-1 || pairs[prev][1]<pairs[idx][0]){
            p=1+f(idx+1,idx,pairs,dp);
        }
        int np=f(idx+1,prev,pairs,dp);
        return dp[idx][prev+1]=Math.max(np,p);
    }
}