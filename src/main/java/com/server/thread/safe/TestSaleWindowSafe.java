package com.server.thread.safe;

/**
 * 多线程（线程安全）：同步代码块
 */
public class TestSaleWindowSafe {
	public static void main(String[] args) {
		SaleWindowSafe sw=new SaleWindowSafe();

		Thread t1=new Thread(sw);
		Thread t2=new Thread(sw);

		t1.setName("窗口A");
		t2.setName("窗口B");

		t1.start();
		t2.start();
	}
}
