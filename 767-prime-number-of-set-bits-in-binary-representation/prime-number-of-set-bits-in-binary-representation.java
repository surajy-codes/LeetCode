class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            if(isPrime(Integer.bitCount(i))){
                ans++;
            }
        }
        return ans;
    }
    boolean isPrime(int n){
        if(n==2) return true;
        if(n==1 || n%2==0) return false;
        int c=0;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}