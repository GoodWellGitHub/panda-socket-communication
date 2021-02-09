package com.communication.s.pool;

import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuajun
 * @date 2021-02-08 09:04
 */
public class CommunicationClientThreadPool {
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 100, 20, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());

    public static void accept(Socket socket) {
        threadPoolExecutor.execute(new CommunicationClientThread(socket));
    }
}
