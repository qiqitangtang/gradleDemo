package concurrent.test;

/**
 * Created by NOTE-026 on 2017/4/5/0005.
 */
public class Test01 {
    public static void main(String[] args) {
        Thread t = new Thread(new RunTest());
        t.start();

        SubTest subTest = new SubTest();
        subTest.start();
    }

}

class RunTest implements Runnable{

    @Override
    public void run() {
        System.out.println("11");
    }
}

class SubTest extends Thread{

    public void run(){
        System.out.println("2");
    }

}