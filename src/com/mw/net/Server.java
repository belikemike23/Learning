package com.mw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mike.wang on 2016/12/19.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务端Socket（ServerSocket），指定并监听这个端口
        ServerSocket serverSocket = new ServerSocket(6666);
        //2.调用accept方法开始监听，等待客户端连接
        System.out.println("***服务器启动完毕，等待客户端连接***");
        Socket socket = serverSocket.accept();
        //3.读取客户端消息
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info = null;
        while ((info = bufferedReader.readLine())!=null){
            System.out.println("客户端说："+info);
        }
        socket.shutdownInput();
        //4.使用输出流相应客户端
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("欢迎您");
        printWriter.flush();
        socket.shutdownOutput();
        //5.关闭资源
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
