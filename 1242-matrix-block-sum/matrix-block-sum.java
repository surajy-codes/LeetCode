class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] pre =new int[n+1][m+1];//to store the last one


        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                pre[i][j]=pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1]+mat[i-1][j-1];
            }
        }

        int[][] ans=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int r1=Math.max(0,i-k);//leftmost
                int c1=Math.max(0,j-k);
                int r2=Math.min(n-1,i+k);
                int c2=Math.min(m-1,j+k);//rightmost

                r1++;r2++;c1++;c2++;//to fix the indexing error, we created while giving values to it

                
                ans[i][j]=pre[r2][c2]-pre[r1-1][c2]-pre[r2][c1-1]+pre[r1-1][c1-1];
            }
        }
        return ans;
    }
}