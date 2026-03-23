class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        double ans=0;
        int n1=nums1.length,n2=nums2.length;
        int leftPart=(n1+n2+1)/2;
        int start=0,end=n1;

        while(start<=end){
            int cut1=(start+end)/2;
            int cut2=leftPart-cut1;

            int left1,left2,right1,right2;
            if(cut1==0){
                left1=Integer.MIN_VALUE;
            }else left1=nums1[cut1-1];
            if(cut1==n1){
                right1=Integer.MAX_VALUE;
            }else right1=nums1[cut1];

            if(cut2==0){
                left2=Integer.MIN_VALUE;
            }else left2=nums2[cut2-1];
            if(cut2==n2){
                right2=Integer.MAX_VALUE;
            }else right2=nums2[cut2];
            
            if(left1<=right2 && left2<=right1){
                if((n1+n2)%2==0){
                    int a=Math.max(left1,left2);
                    int b=Math.min(right1,right2);
                    ans=(a+b)/2.0;
                }else ans=Math.max(left1,left2);
                return ans;
            }
            if(left1>right2) end=cut1-1;
            else start=cut1+1;//if(left2>right1)...
        }
        return ans;
    }
}