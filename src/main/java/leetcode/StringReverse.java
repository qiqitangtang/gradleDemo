package leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auhtor: tangqi@otasim.com
 * @Description: 给定两个字符串，请设计一个方法来判定其中一个字符串是否为
 * 另一个字符串的置换。置换的意思是，通过改变顺序可以使得两个字符串相等。
 * "abc" 为 "cba" 的置换。
 * "aabc" 不是 "abcc" 的置换。
 * @Date: Create in 11:32 2017/6/5
 * @Modified By:
 */
public class StringReverse {
    /**
     * @param a a string
     * @param b a string
     * @return a boolean
     */
    public static boolean stringPermutation(String a, String b) {
//        if ("".equals(a) || "".equals(a)) {
//            return false;
//        }
        if (a.length() != b.length()) {
            return false;
        }
        Stack<Object> stackA = new Stack();
        for (int i = 0; i < a.length(); i++){
            stackA.push(a.charAt(i));
        }
        for (int i = 0; i < a.length(); i++){
            if (stackA.contains(b.charAt(i))) {
                stackA.removeElement(b.charAt(i));
            } else {
                return false;
            }
        }
        if (!stackA.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String strA = "abc";
        String strB = "cba";
        String strC = "aabc";
        String strD = "abcc";
        String strE = "abcd";
        String strF = "bcad";
        String strG = "";
        String strH = "";
        String strI = "lliinnttccooddee";
        String strJ = "lintcodelintcode";
        System.out.println(stringPermutation(strA, strB));
        System.out.println(stringPermutation(strC, strD));
        System.out.println(stringPermutation(strE, strF));
        System.out.println(stringPermutation(strG, strH));
        System.out.println(stringPermutation(strI, strJ));
    }
}
