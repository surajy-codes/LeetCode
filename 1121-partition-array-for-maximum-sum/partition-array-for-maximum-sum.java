class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return f(0,arr,k,dp);
    }
    int f(int idx,int[] arr,int k,int[] dp){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int maxSum=0;
        int max=0,sum=0;
        for(int i=idx;i<idx+k && i<arr.length;i++){
            max=Math.max(max,arr[i]);
            sum=(i-idx+1)*max+f(i+1,arr,k,dp);
            maxSum=Math.max(maxSum,sum);
        }
        return dp[idx] = maxSum;
    }
}