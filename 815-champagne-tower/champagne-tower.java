class Solution {
    public double champagneTower(int N, int qr, int qc) {
        double[][] a=new double[101][101];
        a[0][0]=(double)N;
        boolean over=true;

        int r=0;

        while(r<100 && over){
            over=false;
            for(int c=0;c<=r;c++){
                double temp=a[r][c];
                if(temp>1.0){
                    over=true;
                    temp-=1.0;
                    a[r+1][c]+=temp/2.0;
                    a[r+1][c+1]+=temp/2.0;
                    a[r][c]=1.0;
                }
            }
            r++;
        }
        return a[qr][qc];
    }
}