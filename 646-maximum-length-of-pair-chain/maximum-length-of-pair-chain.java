class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        
        int ans=0;
        for(int i=0;i<pairs.length;i++){
            int prev=Integer.MIN_VALUE;
            int curr=0;
            for(int j=i;j<pairs.length;j++){
                if(prev<pairs[j][0]){
                    prev=pairs[j][1];
                    curr++;
                    ans=Math.max(ans,curr);
                }
            }
        }
        return ans;
    }
}