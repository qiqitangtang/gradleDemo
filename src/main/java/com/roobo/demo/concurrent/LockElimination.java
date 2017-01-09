package com.roobo.demo.concurrent;

import java.util.Vector;

public class LockElimination {
	public String getStr() {
		Vector v = new Vector();
		v.add(3);
		v.add(4);
		return v.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new LockElimination().getStr());
	}
}
