package com.roobo.demo.concurrent;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {

	public static void ioRead(String file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		byte[] b = new byte[1024];
		in.read(b);
		System.out.println(new String(b));
		in.close();
	}

	public static void nioRead(String file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		FileChannel channel = in.getChannel();
		// block oriented loses simplicity and grace comparing with stream
		// oriented

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		byte[] b = buffer.array();
		System.out.println(new String(b));
		channel.close();
	}
}