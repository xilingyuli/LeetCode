/**
 * Created by xilingyuli on 2017/1/31.
 */
public class P14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        int i;
        Label1:
        for(i=0;i<strs[0].length();i++)
        {
            char ch = strs[0].charAt(i);
            for(String str : strs)
            {
                if(i>=str.length()||str.charAt(i)!=ch)
                    break Label1;
            }
        }
        return strs[0].substring(0,i);
    }
}
