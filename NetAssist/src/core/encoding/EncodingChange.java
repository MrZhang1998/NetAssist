package core.encoding;

import java.io.UnsupportedEncodingException;

public class EncodingChange {

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


    /**
     * string to hex
     * @param str
     * @return hex
     */
    public static String convertStringToHex(String str){
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]) + " ");
        }
        return hex.toString();
    }

    /**
     * hex to string 支持两位数以下的ASCII字符
     * @param hex
     * @return string
     */
    public static String convertHexToString(String hex){
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for( int i=0; i<hex.length()-1; i+=3 ){
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char)decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(EncodingChange.convertStringToHex("^m:\u001B"));
        System.out.println(EncodingChange.convertHexToString("5E 6D 3A 1B "));
    }

}
