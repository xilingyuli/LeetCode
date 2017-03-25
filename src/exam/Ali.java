package exam;

import java.util.*;

/** 请完成下面这个函数，实现题目要求的功能
 * 上大学的小明为了完成计算机课作业，开发了款简单的聊天APP，没想到这个APP在学校里挺流行，同学们经常用这个APP来互发消息，但用了一段时间以后，有同学的指出这个APP以明文发送信息，安全性太差，要求小明对信息内容至少要做一个简单的加密。小明略加思考，想出了一个方案，步骤如下：
 * 1） 如果原文为字串s， 则在发送前先将s转换为UTF-8编码，然后按位取反，再将数据以字节为单位反转顺序，得到新的字节数组
 * 2） 取出新字节数组的每一字节，为其生成一个0到100的随机数，用该字节减于随机数，得到的结果作为一个32位整数的最后8位，而随机数按位取反后则作为该整数的9至16位，从而生成一个新的整数，以此类推，得到一个整形数组d
 * 3） 将该整形数组发送给接收方，对方解密后得到原文内容s **/

public class Ali {
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String decrypt(String s) {
        if(s.endsWith("\n"))
            s = s.substring(0, s.length()-1);
        String[] array = s.split(",");
        String result = "";
        for(int i=0;i<array.length;i++)
        {
            int num = Integer.parseInt(array[i]);
            int rand = ~((num & 0x0000FF00)>>8);
            char ch = (char) (~((num & 0x000000FF)+rand));
            result = ch+result;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _s;
        try {
            //_s = in.nextLine();
            _s = "56477,56465,51835,63190,44858,62933,40492\n";
        } catch (Exception e) {
            _s = null;
        }

        res = decrypt(_s);
        System.out.println(res);
    }
}