class Solution {
    public String simplifyPath(String path) {
        String[] strs=path.split("/");
        Stack<String> st=new Stack();
        for(String str : strs){
            if(str.equals("")||str.equals(".")||str.equals(" ")) continue;
            if(str.equals("..")) {
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(str);
            }
        }
        StringBuilder ans=new StringBuilder();
        ans.append("/");
        for(String s : st){
            ans.append(s);
            ans.append("/");
        }
        if(!st.isEmpty()) ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}