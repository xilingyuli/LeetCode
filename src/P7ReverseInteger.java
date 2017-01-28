/**
 * Created by xilingyuli on 2017/1/28.
 */
public class P7ReverseInteger {
    public int reverse(int x)
    {
        try {
            int result = x<0?-x:x;
            result = Integer.parseInt(new StringBuilder(result+"").reverse().toString());
            result = x<0?-result:result;
            return result;
        }catch (Exception e)
        {
            return 0;
        }
    }
    public static void main(String[] args)
    {
        System.out.print(new P7ReverseInteger().reverse(1534236469));
    }
}
