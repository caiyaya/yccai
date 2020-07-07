package com.server.thread.safe;

/**
 * synchronized
 */
public class TestSaleWindowSafe {
	public static void main(String[] args) {
		// 线程不安全
		threadTest1();

		// 多线程（线程安全）：同步代码块
		threadTest2();

		// 多线程（线程安全）：同步方法
		threadTest3();
	}

	private static void threadTest1() {
		SaleWindow sw = new SaleWindow();

		Thread t1 = new Thread(sw);
		Thread t2 = new Thread(sw);

		t1.setName("窗口A");
		t2.setName("窗口B");

		t1.start();
		t2.start();
	}

	private static void threadTest2() {
		SaleWindowSafe sw=new SaleWindowSafe();

		Thread t1=new Thread(sw);
		Thread t2=new Thread(sw);

		t1.setName("窗口A");
		t2.setName("窗口B");

		t1.start();
		t2.start();
	}

	private static void threadTest3() {
		SaleWindowSafe2 sw=new SaleWindowSafe2();

		Thread t1=new Thread(sw);
		Thread t2=new Thread(sw);

		t1.setName("窗口A");
		t2.setName("窗口B");

		t1.start();
		t2.start();
	}

	public static class SaleWindow implements Runnable {

		private int id = 10;   //表示10张火车票   这是共享资源

		//卖10张火车票
		public void run() {
			for (int i = 0; i < 10; i++) {
				if (id > 0) {
					System.out.println(Thread.currentThread().getName()
							+ "卖了编号为" + id + "的火车票");
					id--;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}

	//同步代码块
	public static class SaleWindowSafe implements Runnable {

		private int id = 10;   //表示10张火车票   这是共享资源

		//卖10张火车票
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (this) {
					if (id > 0) {
						System.out.println(Thread.currentThread().getName()
								+ "卖了编号为" + id + "的火车票");
						id--;
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					}
				}
			}
		}
	}

	//同步方法  默认使用this作为锁
	public static class SaleWindowSafe2 implements Runnable {

		private int id = 10;   //表示10张火车票   这是共享资源

		public synchronized  void saleOne(){
			if (id > 0) {
				System.out.println(Thread.currentThread().getName()
						+ "卖了编号为" + id + "的火车票");
				id--;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}

		//卖10张火车票
		public void run() {
			for (int i = 0; i < 10; i++) {
				saleOne();
			}
		}
	}
}
