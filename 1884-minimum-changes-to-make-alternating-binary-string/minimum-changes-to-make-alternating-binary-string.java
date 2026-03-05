class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int d1=0,d2=0;
        for(int i=0;i<n;i++){
            char op1=(i%2==0) ? '0':'1';
            char op2=(i%2==0) ? '1':'0';
            if(op1!=s.charAt(i)) d1++;
            if(op2!=s.charAt(i)) d2++;
        }
        return Math.min(d1,d2);
    }
}