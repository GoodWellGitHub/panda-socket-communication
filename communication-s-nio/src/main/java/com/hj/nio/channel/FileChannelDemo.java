package com.hj.nio.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author wanghuajun
 * @date 2021-06-28 12:54
 */
public class FileChannelDemo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile fromFile=new RandomAccessFile("/Users/admin/record/a1.txt","rw");
        FileChannel fromChannel=fromFile.getChannel();
        RandomAccessFile toFile=new RandomAccessFile("/Users/admin/record/a11.txt","rw");
        FileChannel toChannel=toFile.getChannel();
        long position=0;
        long count=fromChannel.size();
        toChannel.transferFrom(fromChannel,position,count);
    }
}
