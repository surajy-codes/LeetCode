class Solution {
    public int binaryGap(int n) {
        StringBuilder str=new StringBuilder();
        int a=n;
        while(a!=0){
            if((a&1)!=0) str.append(1);
            else str.append(0);
            a=a>>1;
        }
        int p=-1;
        int ans=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                if(p!=-1){
                    ans=Math.max(ans,i-p);
                    p=i;
                }else p=i;
            }
        }
        return ans;
    }
}