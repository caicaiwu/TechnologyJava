package com.walf.test.threads.pools;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPools {

    public static void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run 1 start");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName()+" run 1 end");
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run 2 start");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName()+" run 2 end");
            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run 3 start");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName()+" run 3 end");
            }
        };
        executorService.execute(runnable1);
        executorService.execute(runnable2);
        executorService.execute(runnable3);

        System.out.println("close");

    }

    public static void scheduledThreadPool() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run 1 start");
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName()+" run 1 end");
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run 2 start");
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName()+" run 2 end");
            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run 3 start");
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName()+" run 3 end");
            }
        };

        executorService.scheduleAtFixedRate(runnable1, 0, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(runnable2, 0, 5, TimeUnit.SECONDS);

    }

    public static void FutureTask() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                FutureTask<Void> futureTask =
                        new FutureTask<Void>(new Callable<Void>() {//使用Callable接口作为构造参数
                            public Void call() {
                                //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                                System.out.println(Thread.currentThread().getName()+" futureTask start"+" time: "+new Date());
                                try {
                                    Thread.sleep(10000);
                                } catch (Exception e) {}
                                System.out.println(Thread.currentThread().getName()+" futureTask end"+" time: "+new Date());

                                return null;
                            }
                        });
                executorService.execute(futureTask);
                //在这里可以做别的任何事情

                try {
                    futureTask.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
                } catch (InterruptedException e) {
                    futureTask.cancel(true);
                } catch (ExecutionException e) {
                    futureTask.cancel(true);
                } catch (TimeoutException e) {
                    //futureTask.cancel(true);
                    System.out.println("execute timeout");
                } finally {
                    //executor.shutdown();
                }

            }
        };

        scheduledExecutorService.scheduleAtFixedRate(runnable1, 0, 15, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(runnable1, 0, 15, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(runnable1, 0, 15, TimeUnit.SECONDS);



    }

    public static void main(String[] args) {
        ThreadPools.fixedThreadPool();

    }
}
