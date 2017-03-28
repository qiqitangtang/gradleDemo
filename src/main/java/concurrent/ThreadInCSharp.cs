using System;
using System.Threading;

public class AnyClass {
	public void DoSth() {
		 Console.WriteLine("working");
	}
}

class ThreadTest{
	public static void Main() {
		AnyClass anyClass = new AnyClass();
		ThreadStart threadDelegate = new ThreadStart(anyClass.DoSth);
		Thread myThread = new Thread(threadDelegate);
		
		myThread.Start();
	}
}