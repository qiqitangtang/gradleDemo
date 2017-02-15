package com.roobo.demo.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * Created by NOTE-026 on 2017/2/13/0013.
 */
public class ChannelDemo {

    private static void  readTest(){
        RandomAccessFile aFile = null;
        try {
            String file = ChannelDemo.class.getClassLoader().getResource("nio-data.txt").getPath();
            aFile = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = 0;
        try {
            bytesRead = inChannel.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            try {
                bytesRead = inChannel.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeTest(){
    }

    public static void main(String[] args) {
        readTest();
    }
}
