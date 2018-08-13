package string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public static void main(String[] args) {
        RestoreIPAddress obj = new RestoreIPAddress();
        System.out.println(obj.restoreIpAddresses("1111111111"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper("",s,res,0);
        return res;
    }

    public void helper(String prefix, String suffix, List<String> result, int index){
        if(index == 4 && suffix.length() == 0){
            result.add(prefix.substring(0,prefix.length()-1));
            //substring here to get rid of last '.'
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(suffix.length() < i)
                continue;
            int val = Integer.parseInt(suffix.substring(0,i));
            if(val > 255 || i != String.valueOf(val).length())
                continue;
            /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(prefix + suffix.substring(0,i)+".", suffix.substring(i),result,index+1);
        }
    }
}
