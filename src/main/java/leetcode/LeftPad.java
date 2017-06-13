public class LeftPad{

    static public String leftPad(String originalStr, int size) {
        int strLen = originalStr.length();
        if (strLen < size) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size-strLen ; i++) {
                sb.append(" ");
            }
            return sb.append(originalStr).toString();
        }else{
            return originalStr;
        }
    }

    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < size-originalStr.length(); i++) {
            sb.append(padChar);
        }
        return sb.append(originalStr).toString();
    }

    public static void main(String[] args) {
        //System.out.println(leftPad("foobar", 6));
        System.out.println(leftPad("Test", 20, '#'));
    }
}
