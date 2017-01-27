import java.util.HashMap;

/**
 * Created by xilingyuli on 2017/1/27.
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int begin = 0, maxLen = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                if(map.get(ch)>=begin)
                {
                    if(i-begin>maxLen)
                        maxLen = i-begin;
                    begin = map.get(ch)+1;
                }
            }
            map.put(ch,i);
        }
        if(s.length()-begin>maxLen)
            maxLen = s.length()-begin;
        return maxLen;
    }
}
