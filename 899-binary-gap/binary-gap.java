class Solution {
    public int binaryGap(int n) {
        StringBuilder str=new StringBuilder();
        int a=n;
        int p=-1;
        int ans=0;
        int i=0;
        while(a!=0){
            if((a&1)!=0){
                if(p!=-1){
                    ans=Math.max(ans,i-p);
                    p=i;
                }else p=i;
            }
            a>>=1;
            i++;
        }
        return ans;
        
    }
}