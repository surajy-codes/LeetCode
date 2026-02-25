class Solution {

    class Pair{
        int sets,val;
        Pair(int val,int sets){
            this.val=val;
            this.sets=sets;
        }
    }

    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Pair[] pairs=new Pair[n];
        for(int i=0;i<arr.length;i++){
            Pair p=new Pair(arr[i],Integer.bitCount(arr[i]));
            pairs[i]=p;
        }
        Arrays.sort(pairs,(a,b)->{
            if(a.sets!=b.sets) return a.sets-b.sets;
            return a.val-b.val;
        });
        for(int i=0;i<n;i++){
            arr[i]=pairs[i].val;
        }
        return arr;
    }
}