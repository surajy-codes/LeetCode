class Solution {
    String a,b,c;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        a=s1;b=s2;c=s3;
        int[][] dp=new int[a.length()][b.length()];
        for(int[] i : dp) Arrays.fill(i,-1);
        boolean ans=f(0,0,dp);
        return ans;
    }
    boolean f(int i,int j,int[][] dp){
        int k=i+j;
        if(i==a.length()){
            if(b.substring(j,b.length()).equals(c.substring(k,c.length()))) return true;
            else return false;
        }
        else if(j==b.length()){
            if(a.substring(i,a.length()).equals(c.substring(k,c.length()))) return true;
            else return false;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        char c1=a.charAt(i);
        char c2=b.charAt(j);
        char c3=c.charAt(k);
        boolean ans=false;
        if(c1!=c3 && c2!=c3) return false;
        else{
            if(c2==c3) ans=f(i,j+1,dp);
            if(c1==c3) ans|=f(i+1,j,dp);
        }
        if(ans) dp[i][j]=1;else dp[i][j]=0;
        return ans;
    }
}