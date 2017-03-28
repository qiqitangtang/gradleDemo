package concurrent.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by NOTE-026 on 2017/1/11/0011.
 */
public class ExecutorServiceTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        excuteTest();
        submitWithRunnableTest();
        submitWithCallable();
        invokeAnyTest();
        invokeAllTest();
    }

    /**
     * 无返回结果
     */
    private static void excuteTest(){
        executorService.execute(new Runnable() {
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
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("executorService submitWithRunnable test");
            }
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            //executorService.shutdown();
        }
    }

    /**
     * 带返回结果
     */
    private static void submitWithCallable(){
        Future future = executorService.submit(new Callable() {

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
        }finally {
            //executorService.shutdown();
        }
    }

    private static void invokeAnyTest(){
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });
        String result = null;
        try {
            result = executorService.invokeAny(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            //executorService.shutdown();
        }
        System.out.println("result = " + result);

    }

    private static void invokeAllTest(){
        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> futures = null;
        try {
            futures = executorService.invokeAll(callables);
            for(Future<String> future : futures){
                System.out.println("future.get = " + future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
