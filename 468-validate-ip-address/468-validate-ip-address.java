import java.util.regex.Pattern;   
import java.util.regex.Matcher;    

class Solution {
    public String validIPAddress(String queryIP) {
        if(validIPv4(queryIP)) {
            return "IPv4";
        } else if(validIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    
    private boolean validIPv4(String queryIP) {
        String nums = "(0|([1-9]\\d?)|(1\\d\\d)|(2[0-4]\\d)|(2([0-5]){2}))";
        Pattern p = Pattern.compile("^(" + nums + ".){3}" + nums + "$");
        Matcher m = p.matcher(queryIP);
        return m.matches();
    }
    
    private boolean validIPv6(String queryIP) {
        String val = "((\\d|([a-fA-F])){1,4})";
        Pattern p = Pattern.compile("^(" + val + ":){7}" + val + "$");
        Matcher m = p.matcher(queryIP);
        return m.matches();
    }
}