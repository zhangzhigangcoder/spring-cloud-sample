package com.zhangzhigang.cloud.feign.util;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
 
public class ConnectionUtil {
    /**
     * HttpUrlConnection
     * @param url
     * @return
     */
      public static String sendRequest(String url){
            InputStream is;
            try {
                URL newUrl = new URL(url);
                HttpURLConnection conn=(HttpURLConnection) newUrl.openConnection();
                //设置读去超时时间为10秒
                conn.setReadTimeout(10*1000);
                //设置链接超时为10秒
                conn.setConnectTimeout(15*1000);
                //设置请求方式,GET,POST
                conn.setRequestMethod("POST");
                //接受输入流
                conn.setDoInput(true);
                //启动输出流，当需要传递参数时需要开启
                conn.setDoOutput(true);
                //添加Header
                conn.setRequestProperty("Connection","Keep-Alive");
                conn.setRequestProperty("Content-type","application/json");
                //添加请求参数，注意：如果是GET请求，参数要写在URL中
                OutputStream output=conn.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output,"UTF-8"));
                //写入参数 用&分割
                writer.write("{\"id\":123}");
                writer.flush();
                writer.close();
                //发起请求
                conn.connect();
                //状态码 
                //200 - 服务器成功返回网页 
                //404 - 请求的网页不存在 
                //503 - 服务不可用
                int code=conn.getResponseCode();
                if(code==200){
                    is=conn.getInputStream();     
                    //获取结果
                    String result=readInputStream(is);
                    return result;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        /** 
         * 把输入流的内容转化成字符串 
         * @param is 
         * @return 
         */  
        public static String readInputStream(InputStream is){  
            try {  
                ByteArrayOutputStream baos=new ByteArrayOutputStream();  
                int length=0;  
                byte[] buffer=new byte[1024];  
                while((length=is.read(buffer))!=-1){  
                    baos.write(buffer, 0, length);  
                }  
                is.close();  
                baos.close();  
                //或者用这种方法  
                //byte[] result=baos.toByteArray();  
                //return new String(result);  
                return baos.toString("UTF-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
                return "获取失败";  
            }  
        }   

        public static void main(String[] args) {
			String url = "http://localhost:7901/user";
			String result = sendRequest(url);
			System.out.println(result);
		}
}