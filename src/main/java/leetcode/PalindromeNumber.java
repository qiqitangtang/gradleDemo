package leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auhtor: tangqi@otasim.com
 * @Description: 回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。
 * @Date: Create in 13:33 2017/6/5
 * @Modified By:
 */
public class PalindromeNumber {

    public static boolean palindromeNumber(int num) {
        String newStr = num + "";
        for(int i = 0; i < newStr.length(); i++){
            if (newStr.charAt(i) != newStr.charAt(newStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
     * 数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
     * @return
     */
    public static int getMaxLengthStr(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        boolean isHash = false;
        int sum = 0;
        Iterator<Map.Entry<Character, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            int value = entryIterator.next().getValue();
            if (value % 2 == 0) {
                sum += value;
            } else {
                sum += value-1;
                isHash = true;
            }
        }
        if (isHash) {
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(palindromeNumber(11));
//        System.out.println(palindromeNumber(121));
//        System.out.println(palindromeNumber(12321));
//        System.out.println(palindromeNumber(23));
//        System.out.println(palindromeNumber(32));
//        System.out.println(palindromeNumber(1232));
        System.out.println(getMaxLengthStr("aaa"));
    }
}
