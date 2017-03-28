package concurrent;

public class ThreadLocalUsage extends Thread {
	public User user = new User();

	public User getUser() {
		return user;
	}

	@Override
	public void run() {
		this.user.set("var1");

		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(this.user.get());
		}
	}

	public static void main(String[] args) {

		ThreadLocalUsage thread = new ThreadLocalUsage();
		thread.start();

		try {
			sleep(4000);
		} catch (InterruptedException e) {
		}

		thread.user.set("var2");

	}
}

class User {

	private static ThreadLocal<Object> enclosure = new ThreadLocal<Object>(); // is it must be static?

	public void set(Object object) {
		enclosure.set(object);
	}

	public Object get() {
		return enclosure.get();
	}
}
