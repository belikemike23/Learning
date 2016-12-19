package com.mw.net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by mike.wang on 2016/12/19.
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器和端口
            Socket socket = new Socket("localhost",6666);
            //2.使用输出流向服务端发送消息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：mike；密码：123");
            printWriter.flush();
            socket.shutdownOutput();
            //3.获取输入流，读取服务器端的响应消息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine())!=null){
                System.out.println("服务端说："+info);
            }
            socket.shutdownInput();
            //4.关闭资源
            printWriter.close();
            outputStream.close();
            socket.close();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
