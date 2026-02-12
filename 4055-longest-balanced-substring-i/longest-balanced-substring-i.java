class Solution {
    public int longestBalanced(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(isOk(map,map.get(ch))){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
    public boolean isOk(HashMap<Character,Integer> map,int f){
        for(int v : map.values()){
            if(v!=f) return false;
        }
        return true;
    }
}