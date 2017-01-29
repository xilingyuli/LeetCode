/**
 * Created by xilingyuli on 2017/1/29.
 */
public class P13RomanToInteger {
    public int romanToInt(String s) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int num = 0;
        for(int i=0;i<strs.length;i++) {
            while(s.startsWith(strs[i])) {
                num += values[i];
                s = s.substring(strs[i].length());
            }
        }
        return num;
    }
    public static void main(String[] args)
    {
        System.out.print(new P13RomanToInteger().romanToInt("MMMDLXXXVI"));
    }
}
