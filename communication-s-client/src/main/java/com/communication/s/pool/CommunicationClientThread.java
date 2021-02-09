package com.communication.s.pool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wanghuajun
 * @date 2021-02-08 09:14
 */
public class CommunicationClientThread implements Runnable {
    private Socket socket;

    public CommunicationClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                String threadName = Thread.currentThread().getName();
                outputStream.write(("my name is " + threadName + " " + socket.getPort()).getBytes());

                InputStream inputStream = socket.getInputStream();
                byte[] cacheValue = new byte[1024];
                int length = 0;
                do {
                    length = inputStream.read(cacheValue);
                    System.out.println(new String(cacheValue));
                } while (length != -1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
