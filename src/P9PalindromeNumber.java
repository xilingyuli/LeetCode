/**
 * Created by xilingyuli on 2017/1/28.
 */
public class P9PalindromeNumber {
    public boolean isPalindrome(int x) {
        try {
            int result = Integer.parseInt(new StringBuilder(x+"").reverse().toString());
            return result==x;
        }catch (Exception e)
        {
            return false;
        }
    }
    public static void main(String[] args)
    {
        System.out.print(new P9PalindromeNumber().isPalindrome(-2147447412));
    }
}
