class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans =new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                add(i,j,k,mat,ans);
            }
        }
        return ans;
    }

    public void add(int r,int c,int k,int[][] mat,int[][] ans){
        int sum=0;
        for(int i=r-k;i<=r+k;i++){
            for(int j=c-k;j<=c+k;j++){
                if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) continue;
                sum+=mat[i][j];
            }
        }
        ans[r][c]=sum;
    }
}