package com.roobo.demo.concurrent.test;

import java.util.concurrent.*;

/**
 * Created by NOTE-026 on 2017/1/11/0011.
 */
public class ExcutorServiceTest {

    private static ExecutorService excutorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        excuteTest();
        submitWithRunnableTest();
        submitWithCallable();
    }

    /**
     * 无返回结果
     */
    private static void excuteTest(){
        excutorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("executorService excuete test");
            }
        });
    }

    /**
     * 获取返回结果
     */
    private static void submitWithRunnableTest(){
        Future future = excutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("excutorService submitWithRunnable test");
            }
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void submitWithCallable(){
        Future future = excutorService.submit(new Callable() {

            @Override
            public Object call() throws Exception {
                System.out.println("executorService submitWithCallable test");
                return "Callable Result";
            }
        });
        try {
            System.out.println("future get() = " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
