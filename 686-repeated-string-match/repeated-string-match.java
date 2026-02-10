class Solution {
    public int repeatedStringMatch(String a, String b) {
        int ans=1;
        String add=a;
        while(b.length()>a.length()){
            a+=add;
            ans++;
        }
        a+=add;
        ans++;
        if(a.contains(b)){
            if(a.substring(0,a.length()-add.length()).contains(b)) return ans-1;
            else return ans;
        }   
        return -1;
    }
}