class Solution {
    public int compareVersion(String version1, String version2) {
        String[] num1=version1.split("\\.");
        String[] num2=version2.split("\\.");

        int[] arr1=new int[500];
        int[] arr2=new int[500];

        for(int i=0;i<num1.length;i++){
            arr1[i]=Integer.parseInt(num1[i]);
        }
        for(int i=0;i<num2.length;i++){
            arr2[i]=Integer.parseInt(num2[i]);
        }

        for(int i=0;i<500;i++){
            if(arr1[i]<arr2[i]) return -1;
            else if(arr1[i]>arr2[i]) return 1;
        }
        return 0;
    }
}