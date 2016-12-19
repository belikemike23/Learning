package com.mw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mike.wang on 2016/12/19.
 */
public class ServerThread extends Thread{
    private Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    //线程执行操作，响应客户端请求
    public void run(){
        InputStream inputStream =null;
        InputStreamReader inputStreamReader =null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try{
            System.out.println("***服务器启动完毕，等待客户端连接***");
            //3.读取客户端消息
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine())!=null){
                System.out.println("客户端说："+info);
            }
            socket.shutdownInput();
            //4.使用输出流相应客户端
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您");
            printWriter.flush();
            socket.shutdownOutput();}
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        }
    }
}
