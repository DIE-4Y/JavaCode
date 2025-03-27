package com.nenu.file_;

import javax.security.auth.kerberos.KerberosTicket;
import java.io.*;

public class StringUtils {
    public static void main(String[] args) {

    }

    /**
     * 将数据转为字节数组
     */
    public static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    /**
     * 将字节数组转为字符串
     */
    public static String steamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line+"\r\n");
        }
        return stringBuilder.toString();
    }
}
