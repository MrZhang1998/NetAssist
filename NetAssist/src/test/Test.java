package test;

import java.io.UnsupportedEncodingException;

public class Test {


    /**
     * 用于构建十六进制字符的输出的大写字符数组
     */
    private static final char[] DIGITS_UPPER = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };


    /**
     * 字符串转换成十六进制字符串
     *
     * @param str 待转换的ASCII字符串
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2Hex(String str) throws UnsupportedEncodingException {

        char[] chars = DIGITS_UPPER;
        StringBuilder hexBuilder = new StringBuilder("");
        str = new String(str.getBytes(),"utf-8");//指定编码方式
        byte[] originalBytes = str.getBytes();
        int bit;

        for (int i = 0; i < originalBytes.length; i++) {
            //System.out.println("originalBytes:" + originalBytes[i]);
            bit = (originalBytes[i] & 0x0f0) >> 4;
            //System.out.println(bit);
            hexBuilder.append(chars[bit]);
            bit = originalBytes[i] & 0x0f;
            hexBuilder.append(chars[bit]);
            hexBuilder.append(' ');
        }
        return hexBuilder.toString().trim();
    }


    public static String hex2Str(String hex){
        return "";
    }

    public static void main(String[] args) {
        try {
            System.out.println(Test.str2Hex("我是"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
