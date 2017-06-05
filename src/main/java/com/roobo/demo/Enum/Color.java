package com.roobo.demo.Enum;

/**
 *
 */
public enum Color {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    Color(String name, int num){
        this.name = name;
        this.num =  num;
    }

    // 普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getNum() == index) {
                return c.name;
            }
        }
        return null;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.num+"_"+this.name;
    }
}
