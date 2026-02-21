class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[][] dp=new int[words.length][words.length+1];
        for(int[] a : dp) Arrays.fill(a,-1);
        int ans=f(0,-1,words,dp);
        return ans;
    }

    boolean isPred(String a,String b){
        if(b.length()-1!=a.length()) return false;
        int c=0;
        int j=0;
        for(int i=0;i<a.length();){
            char ch1=a.charAt(i);
            char ch2=b.charAt(j);
            if(ch1!=ch2){
                c++;
                if(c>1) return false;
                j++;
            }else if(ch1==ch2){
                i++;
                j++;
            }
        }
        return true;
    }

    int f(int idx,int prev,String[] words,int[][] dp){
        if(idx==words.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int p=0;
        if(prev==-1 || isPred(words[prev],words[idx])){
            p=1+f(idx+1,idx,words,dp);
        }
        int np=f(idx+1,prev,words,dp);
        return dp[idx][prev+1]=Math.max(p,np);
    }
}