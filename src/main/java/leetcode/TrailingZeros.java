package leetcode;

/**
 * Created by NOTE-026 on 2017/2/13/0013.
 * 设计一个算法，计算出n阶乘中尾部零的个数
 */
public class TrailingZeros {

    public static long trailingZeros(long n) {
        return n / 5;
    }

    public static void main(String[] args) {
        //System.out.println(trailingZeros(21));
        System.out.println(test(20));
    }

    public static long test(long n){
        if(n >= 1){
            return n * test(n-1);
        }else{
            return 1;
        }

    }
}
