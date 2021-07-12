package com.hj.nio.selector;

import java.io.RandomAccessFile;
import java.nio.channels.*;
import java.util.Set;

/**
 * @author wanghuajun
 * @date 2021-07-03 12:48
 */
public class SelectorDemo {
    public static void main(String[] args) throws Exception{
        Selector selector=Selector.open();

        Set<SelectionKey>  selectionKeys=selector.selectedKeys();

        ServerSocketChannel socketChannel=ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector,1);
    }
}
