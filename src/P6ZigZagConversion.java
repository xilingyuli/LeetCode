/**
 * Created by xilingyuli on 2017/1/28.
 */
public class P6ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        StringBuilder stringBuilder = new StringBuilder();
        int step = 2*numRows-2;
        for(int i=0;i<numRows;i++)
        {
            if(i==0||i==numRows-1)
            {
                for(int j=i;j<s.length();j+=step)
                    stringBuilder.append(s.charAt(j));
            }
            else
            {
                for(int j=0;j-i<s.length();j+=step) {
                    if(j-i>=0)
                        stringBuilder.append(s.charAt(j-i));
                    if(j+i<s.length())
                        stringBuilder.append(s.charAt(j+i));
                }
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args)
    {
        System.out.print(new P6ZigZagConversion().convert("PAYPALISHIRING",3));
    }
}
