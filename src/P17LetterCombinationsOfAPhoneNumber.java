import java.util.*;

/**
 * Created by xilingyuli on 2017/3/21.
 */
public class P17LetterCombinationsOfAPhoneNumber {
    List<String> list = new ArrayList<>();
    static Map<Character, List<Character>> map = new HashMap<>();
    static {
        map.put('0', Arrays.asList(' '));
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
    }
    public List<String> letterCombinations(String digits) {
        list.clear();
        add(digits,0,"");
        return list;
    }
    public void add(String digits, int index, String pre)
    {
        if(index==digits.length())
        {
            if(!pre.isEmpty())
                list.add(pre);
            return;
        }
        for(char ch : map.get(digits.charAt(index)))
        {
            add(digits,index+1,pre+ch);
        }
    }
}
