/**
 * Created by xilingyuli on 2017/1/27.
 */
public class P5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] str = new char[s.length()*2+1];
        for(int i=0;i<s.length();i++)
        {
            str[i*2+1] = s.charAt(i);
            str[i*2] = '#';
        }
        str[str.length-1] = '#';
        int mx = 0, id = 0, maxIndex = 0;
        int[] p = new int[s.length()*2+1];
        for(int i = 1; i <  str.length; i++)
        {
            if(mx > i)
                p[i] = (p[2*id - i] < (mx - i) ? p[2*id - i] : (mx - i));
            else
                p[i] = 1;

            while(i-p[i]>=0&&i + p[i]<str.length&&str[i - p[i]] == str[i + p[i]])
                p[i]++;

            if(i + p[i] > mx)
            {
                mx = i + p[i];
                id = i;
            }

            if(p[i] > p[maxIndex])
                maxIndex = i;

        }
        StringBuilder ans = new StringBuilder();
        for(int i=maxIndex-p[maxIndex]+1;i<=maxIndex+p[maxIndex]-1;i++)
            if(str[i]!='#')
                ans.append(str[i]);
        return ans.toString();
    }
}
