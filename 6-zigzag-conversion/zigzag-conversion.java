class Solution {
    public String convert(String s, int n) {
        List<List<Character>> lists=new ArrayList<>();
        for(int i=0;i<n;i++) lists.add(new ArrayList<>());

        int j=0;
        while(j<s.length()){
            for(int i=0;i<n && j<s.length();i++,j++){
                lists.get(i).add(s.charAt(j));
            }
            for(int i=n-2;i>0 && j<s.length();i--,j++){
                lists.get(i).add(s.charAt(j));
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            for(char c : lists.get(i)) ans.append(c);
        }
        return ans.toString();
    }
}