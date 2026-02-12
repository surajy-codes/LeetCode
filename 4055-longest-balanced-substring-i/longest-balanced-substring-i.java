class Solution {
    public int longestBalanced(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[] map=new int[26];
            int dis=0;
            int max=0;
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);

                int idx=ch-'a';

                if(map[idx]==0) dis++;
                map[idx]++;
                max=Math.max(max,map[idx]);

                if(j-i+1==dis*max){

                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
