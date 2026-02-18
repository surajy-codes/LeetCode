class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        
        int ans=0;
        int prev=Integer.MIN_VALUE;
        for(int i=0;i<pairs.length;i++){
            if(prev<pairs[i][0]){
                ans++;
                prev=pairs[i][1];
            }
        }
        return ans;
    }
}