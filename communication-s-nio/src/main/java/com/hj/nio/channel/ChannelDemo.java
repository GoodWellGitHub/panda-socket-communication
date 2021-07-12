package com.hj.nio.channel;

/**
 * @author wanghuajun
 * @date 2021-06-17 12:50
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * * 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
 * * 通道可以异步地读写。
 * * 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。
 * 这些是Java NIO中最重要的通道的实现：
 * <p>
 * FileChannel
 * DatagramChannel
 * SocketChannel
 * ServerSocketChannel
 * <p>
 * FileChannel 从文件中读写数据。
 * DatagramChannel 能通过UDP读写网络中的数据。
 * SocketChannel 能通过TCP读写网络中的数据。
 * ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
 */

public class ChannelDemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("/Users/admin/record/searchat.txt", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int bytes = fileChannel.read(byteBuffer);
            while (bytes != -1) {
                System.out.println("readSize=" + bytes);
                byteBuffer.flip();//将byteBuffer从写切换到读模式
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();//clear()方法会清空整个缓冲区  compact()方法只会清除已经读过的数据
                bytes = fileChannel.read(byteBuffer);
            }
            accessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
