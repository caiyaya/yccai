package com.server.thread.communication.farmerchild;

/**
 * 生产者消费者模式
 */
public class TestFarmerChild {
	public static void main(String[] args) {
		new Farmer().start();
		new Child().start();
	}
}
