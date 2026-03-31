class Solution {
    public int countPrimes(int n) {
        boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);
        if(n>0) prime[0]=false;
        if(n>1) prime[1]=false;
        for(int i=2;i*i<n;i++){
            if(prime[i]){
                for(int j=i*i;j<n;j+=i){//for calculating every multiple of the prime, 
                prime[j]=false;
                }
            }
        }
        int ans=0;
        for(boolean p : prime) if(p) ans++;
        return ans;
    }
}