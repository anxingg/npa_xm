package com.zkpt.util;

import java.nio.charset.Charset;

/**
 * 十六进制和ASCII码互相转换 String转数组
 * 
 * @author 孙培
 *
 */
public class ProtocolTxTUtil {
    /**
     * ASCII码转换为16进制
     * 
     * @param str
     * @return
     */
    public static String convertStringToHex(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        return hex.toString();
    }

    /**
     * 16进制转换为ASCII
     * 
     * @param hex
     * @return
     */
    public static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        // 49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            // grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            // convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            // convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    /**
     * String转char[]
     * 
     * @param str
     * @return
     */
    public static char[] strToCharArray(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        return charArray;
    }

    /**
     * String转byte[]
     * 
     * @param str
     * @return
     */
    public static byte[] strToByteArray(String str) {
        if (str == null) {
            return null;
        }
        byte[] byteArray = str.getBytes();
        return byteArray;
    }

    /**
     * byte[]转String
     * 
     * @param byteArray
     * @param charset
     * @return
     */
    public static String byteArrayToStr(byte[] byteArray, Charset charset) {
        if (byteArray == null) {
            return null;
        }
        String str = new String(byteArray, charset);
        return str;
    }

    /**
     * byte[]转十六进制String
     * 
     * @param byteArray
     * @return
     */
    public static String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * 十六进制String转byte[]
     * 
     * @param str
     * @return
     */
    public static byte[] hexStrToByteArray(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++) {
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte) Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }

    /**
     * 补位操作
     * 
     * @param text
     * @param com_text
     * @param count
     * @param left
     * @return
     */
    public static String complementText(String text, char com_text, int length, boolean left) {
        if (length <= text.length()) // 如果目标文字比补位文字还要长,不做处理
            return text;

        int com_length = length - text.length(); // 需要补位的文字;
        StringBuffer temp_txt = new StringBuffer();
        for (int i = 0; i < com_length; i++)
            temp_txt.append(com_text);

        if (left)
            temp_txt.append(text);
        else
            temp_txt.insert(0, text);

        return temp_txt.toString();
    }
}
