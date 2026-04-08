public class Codec {

    // Encodes a URL to a shortened URL.
    String base="http://t/";
    HashMap<Integer,String> map=new HashMap<>();
    int id;
    public String encode(String longUrl) {
        map.put(id,longUrl);
        return base+id++;        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int k=Integer.parseInt(shortUrl.replace(base,""));
        return map.get(k);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));