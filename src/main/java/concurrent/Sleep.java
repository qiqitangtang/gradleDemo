package concurrent;

public class Sleep extends Thread {
	@Override
	public void run() {
		System.out.println("start");
		synchronized (this) { // sleep() can use (or not) any synchronization resource
			try {
				/**
				 * Do you know: <br>
				 * 1. Why sleep() is designed as a static method comparing with
				 * wait?<br>
				 * 2. Why sleep() must have a timeout parameter?
				 */
				this.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace(); // notify won't throw exception
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Sleep();
		thread.start();
		try {
			sleep(2000);
		} catch (InterruptedException e) {
		}
		synchronized (thread) {
			System.out.println("Has sleep() released the lock!");
			thread.notify();
		}
	}
}
