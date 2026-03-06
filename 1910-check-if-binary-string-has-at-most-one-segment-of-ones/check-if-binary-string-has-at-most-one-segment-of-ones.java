class Solution {
    public boolean checkOnesSegment(String s) {
        int i=0;
        while(i<s.length() && s.charAt(i)=='0') i++;
        while(i<s.length() && s.charAt(i)=='1') i++;
        while(i<s.length() && s.charAt(i)=='0') i++;
        if(i<s.length()) return false;
        return true;
    }
}