package com.communication.s.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wanghuajun
 * @date 2021-02-02 09:21
 */
public class CommunicationClient {
    public static void main(String[] args) {
        int port = 8111;
        String host = "localhost";
        Socket[] sockets = new Socket[100];
        try {
            for (int i = 0; i < 100; i++) {
                sockets[i] = new Socket(host, port);
                System.out.println("第" + i + "个客户端连接成功");
            }
            System.out.println("结束了！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
