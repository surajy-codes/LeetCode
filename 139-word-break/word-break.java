class Solution {
    Map<String,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map=new HashMap<>();
        return helper(s,wordDict);
    }
    

    boolean helper(String s, List<String> words){
        if(map.containsKey(s)) return map.get(s);
        if(s.equals("")) return true;
        
        for(int i=0;i<words.size();i++){
            String str=words.get(i);
            if(s.startsWith(str)) if(helper(s.substring(str.length(),s.length()),words)) {
                map.put(s.substring(str.length(),s.length()),true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }

}