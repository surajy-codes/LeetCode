class Solution {
    public String convert(String s, int n) {
        if(n==1) return s;
        StringBuilder[] strs=new StringBuilder[n];
        for(int i=0;i<n;i++) strs[i]=new StringBuilder();
        int i=0;
        boolean flag=false;
        for(char c : s.toCharArray()){
            strs[i].append(c);
            if(i==0 || i==n-1) flag=!flag;
            i=flag?i+1:i-1;
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder st : strs) ans.append(st);
        return ans.toString();
    }
}