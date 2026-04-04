class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] dun) {
        dp=new int[dun.length][dun[0].length];
        for(int[] i : dp) Arrays.fill(i,-1);
        return f(0,0,dun);
    }
    int f(int i,int j,int[][] dun){
        if(i>=dun.length || j>=dun[0].length) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==dun.length-1 && j==dun[0].length-1){
            return dun[i][j]>0?1:1-dun[i][j];
        }
        int right=f(i,j+1,dun);
        int left=f(i+1,j,dun);
        int n=Math.min(right,left);
        return dp[i][j] = n-dun[i][j]>0?n-dun[i][j]:1;
        //Minimum health needed at current cell so that after applying dun[i][j],
        //we can move to the next cell and still have at least 1 health
    }
}