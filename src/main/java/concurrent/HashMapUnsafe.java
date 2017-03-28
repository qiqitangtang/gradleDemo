package concurrent;

import java.util.HashMap;
import java.util.Map;

public class HashMapUnsafe {
	private Map map = new HashMap(); //ConcurrentHashMap

	public HashMapUnsafe() {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 50000; i++) {
					map.put(new Integer(i), Integer.valueOf(i));
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 50000; i++) {
					map.put(new Integer(i), Integer.valueOf(i));
				}
			}
		};
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			new HashMapUnsafe(); // you may need to try several times
		System.out.println("finish the loop");
	}
}