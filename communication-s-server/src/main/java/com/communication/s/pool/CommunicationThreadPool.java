package com.communication.s.pool;

import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuajun
 * @date 2021-02-07 22:40
 */
public class CommunicationThreadPool {
    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 100, 20, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
    public static void acceptCommunication(Socket socket) {
        threadPoolExecutor.execute(new CommunicationThread(socket));
    }
}
