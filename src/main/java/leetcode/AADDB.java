package leetcode;

/**
 * Created by NOTE-026 on 2017/2/13/0013.
 * 不用运算符实现A+B
 */
public class AADDB {
    public static void main(String[] args) {
        //System.out.println(aplusb(2,-1));
        System.out.println(Add2(2,-1));
    }

    public static int aplusb(int a, int b) {
        Math.abs(a);
        // write your code here, try to do it without arithmetic operators.
        return a ^ b ;
    }

    public static int Add2(int a, int b)
    {
        if(0 == b)
            return a;
        int cxor = a^b;
        int cand = a&b;
        return Add2(cxor, cand<<1);
    }
}
