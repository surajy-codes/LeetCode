class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        // else if(t.equals(s)) return t;
        int[] map=new int[256];
        for(char c : t.toCharArray()){
            map[c]++;
        }

        int i=0,j=0,counter=t.length(),startIdx=-1,minLen=Integer.MAX_VALUE;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map[ch]>0) counter--;
            map[ch]--;
            j++;
            while(counter==0){
                if(minLen>j-i){
                    minLen=j-i;
                    startIdx=i;
                }
                char ch2=s.charAt(i);
                map[ch2]++;
                if(map[ch2]>0) counter++;
                i++;
            }
        }

        if(startIdx==-1) return "";
        else return s.substring(startIdx,startIdx+minLen);
    }
}