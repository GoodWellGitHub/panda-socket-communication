package com.communication.s.pool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wanghuajun
 * @date 2021-02-07 23:34
 */
public class CommunicationThread implements Runnable {
    private Socket socket;

    public CommunicationThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] cacheByte = new byte[1024];
            int cacheLength = 0;
            do {
                cacheLength = inputStream.read(cacheByte);
                String str = new String(cacheByte);
                System.out.println(str);
            } while (cacheLength != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
