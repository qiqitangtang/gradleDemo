package concurrent.test;

/**
 * Created by NOTE-026 on 2017/3/30/0030.
 */
public class SynchronizedTest {


}
class Obj extends Thread {
    Runtest r;
    int i = 0;

    public Obj(Runtest r, int i) {
        this.r = r;
        this.i = i;
    }

    public void run() {
        r.noSyn(this.getId());
        //用以测试同一个对象在不同线程中访问不同方法
        if(i % 2 == 0){
            r.outMethod2();//对象锁方法2
        }else{
            r.outMethod();//对象锁方法1
        }
        Runtest.plus(); //类锁方法
    }
}

class Runtest {
    static int i = 0;
    public void noSyn(long threadId) {
        System.out.println("nosyn: class obj->" + this + ", threadId->" + threadId);
    }

    synchronized public void outMethod() {
        System.out.println("in outMethod begin");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }
        System.out.println("in outMethod end");
    }

    synchronized public void outMethod2() {
        System.out.println("in outMethod2 begin");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }
        System.out.println("in outMethod2 end");
    }

    public static void plus() {
        synchronized (Runtest.class) {
            System.out.println("start: " + i);
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
            }
            i++;
            System.out.println("i is " + i);
        }
    }

    public static void main(String[] args) {
        Runtest runtest = new Runtest();
        for (int i = 0; i < 10; i++) {
            //Thread thread = new Obj(runtest, i);// 1同一个RunTest1对象但每次有个新的线程
            //thread.start();

           Runtest rruntest = new Runtest(); //2 循环每次都声明一个新的对象
           Thread thread = new Obj(rruntest, i);
           thread.start();
        }
    }
}
