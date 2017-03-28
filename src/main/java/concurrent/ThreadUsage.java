package concurrent;

public class ThreadUsage implements Runnable {

	@Override
	public void run() {
		System.out.println("implement");
	}

	public static void main(String[] args) {
		Thread impl = new Thread(new ThreadUsage());
		Thread inherit = new ThreadInherit();
		
		impl.start();
		inherit.start();
	}
}

class ThreadInherit extends Thread {
	@Override
	public void run() {
		System.out.println("inherit");
	}
}