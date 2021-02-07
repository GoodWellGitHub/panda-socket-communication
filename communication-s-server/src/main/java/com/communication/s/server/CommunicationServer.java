package com.communication.s.server;

import com.communication.s.pool.CommunicationThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wanghuajun
 * @date 2021-02-02 09:20
 */
public class CommunicationServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8111);
            service(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void service(ServerSocket serverSocket) throws IOException {
        System.out.println("监听开始 ...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " 绑定成功");
            CommunicationThreadPool.acceptCommunication(socket);
        }
    }
}
