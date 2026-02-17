class Solution {
    public List<String> readBinaryWatch(int t) {
        List<String> ans=new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==t){
                    StringBuilder curr=new StringBuilder();
                    curr.append(h);curr.append(":");
                    if(m<10) curr.append("0");
                    curr.append(m);
                    ans.add(curr.toString());
                }
            }
        }
        return ans;
    }
}