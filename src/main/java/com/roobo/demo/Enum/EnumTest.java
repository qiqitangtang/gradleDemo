package com.roobo.demo.Enum;

/**
 * Created by NOTE-026 on 2017/1/9/0009.
 */
public class EnumTest {

    public static void main(String[] args) {

        //输出某一枚举的值
        System.out.println( Color.RED.getName() );
        System.out.println( Color.RED.getNum() );

        //遍历所有的枚举
        for( Color color : Color.values()){
            System.out.println( color + "  name: " + color.getName() + "  index: " + color.getNum() );
        }
    }

}
