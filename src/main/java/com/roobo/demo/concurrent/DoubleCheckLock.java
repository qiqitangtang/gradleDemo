package com.roobo.demo.concurrent;

public class DoubleCheckLock {
	private volatile static DoubleCheckLock instance; // Do I need add "volatile" here?
	private final Element element = new Element(); // Should I add "final" here? Is a "final" enough here? Or I should use "volatile"?

	private DoubleCheckLock() {
	}

	public static DoubleCheckLock getInstance() {
		if (null == instance)
			synchronized (DoubleCheckLock.class) {
				if (null == instance)
					instance = new DoubleCheckLock();
					//the writes which initialize instance and the write to the instance field can be reordered without "volatile"
			}

		return instance;
	}

	public Element getElement() {
		return element;
	}

}

class Element {
	public String name = new String("abc");
}