class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry>0){
            int digA=0;
            if(i>=0){
                digA=a.charAt(i)-'0';
                i--;
            }
            int digB=0;
            if(j>=0) {
                digB=b.charAt(j)-'0';
                j--;
            }
            int sum=digA+digB+carry;
            ans.append(sum%2);
            carry=sum/2;
        }
        return ans.reverse().toString();
    }
}