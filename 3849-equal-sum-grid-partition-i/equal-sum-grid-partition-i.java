class Solution {
    long total=0;
    void sum(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                total+=grid[i][j];
            }
        }
    }
    public boolean canPartitionGrid(int[][] grid) {
        sum(grid);
        if(total%2!=0) return false;
        return f1(grid)||f2(grid);
    }
    long rowSum(int[] a){
        long sum=0;
        for(int i : a){
            sum+=i;
        }
        return sum;
    }
    boolean f1(int[][] grid){
        long pre=0;
        for(int i=0;i<grid.length;i++){
            pre+=rowSum(grid[i]);
            if(pre==total/2) return true;
        }
        return false;
    }
    long colSum(int[][] grid,int col){
        long sum=0;
        for(int i=0;i<grid.length;i++){
            sum+=grid[i][col];
        }
        return sum;
    }
    boolean f2(int[][] grid){
        long pre=0;
        for(int i=0;i<grid[0].length;i++){
            pre+=colSum(grid,i);
            if(pre==total/2) return true;
        }
        return false;
    }
}