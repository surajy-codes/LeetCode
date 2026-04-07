class Solution {
    public int twoEggDrop(int n) {
        return f(2,n,new int[n+1][3]);
    }
    int f(int eggs,int f,int[][] dp){
        if(eggs==1 || f<=1) return f;
        if(dp[f][eggs]!=0) return dp[f][eggs];
        int p=Integer.MAX_VALUE;
        for(int i=1;i<=f;i++){
            p=Math.min(p,1+Math.max(f(eggs-1,i-1,dp),f(eggs,f-i,dp)));//assume worst will happen,.. by nature of the question itself,...
        }
        return dp[f][eggs]=p;
    }
}