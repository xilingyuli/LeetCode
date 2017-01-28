import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xilingyuli on 2017/1/28.
 */
public class P8StringToInteger {
    public int myAtoi(String str) {
        try {
            Matcher matcher = Pattern.compile("^[-+]?\\d+").matcher(str.trim());
            if(matcher.find()) {
                str = matcher.group();
                return Integer.parseInt(str);
            }
            else
                return 0;
        }catch (Exception e)
        {
            return str.startsWith("-")?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }
    public static void main(String[] args){
        System.out.print(new P8StringToInteger().myAtoi("+-2"));
    }
}
