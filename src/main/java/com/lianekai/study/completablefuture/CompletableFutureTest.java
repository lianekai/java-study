package com.lianekai.study.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2023/3/26 23:01
 **/
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture
         *
         * 一、什么是CompletableFuture
         * 通俗理解：CompletableFuture其实是一个线程人任务编排工具类
         * 提供了静态方法提交任务和组织任务的执行以及聚合任务执行·结果等等
         * JDK1.8以后才有的
         *
         * 二、为什么有CompletableFuture
         * 降低并发编程复杂度
         * 在JDK1.8前都是通过哦Tread+Runnable 或者 Tread+Callable 完成
         * 如果需要多个任务同时执行，；并且关系同步关系可能加上CountDownLatch、CyclicBarrier d等等线程同步工具，导致并发编程变得复杂
         * 而CompletableFuture帮助我们封装任务提交，同步方法，让我很简轻松完成任务提交，同步编排。
         *
         * 三、怎么使用
         *
         */


        /**
         * 1.任务提交
         *  CompletableFuture.supplyAsync() 有返回值
         *  CompletableFuture.runAsync()    无返回值
         *  它们都可以自定义线程池
         */

//
//        testSupplyAsync();

//        testRunAsync();


        /**
         * 2.任务依赖关系编排：一个任务执行依赖另一个任务的执行结果
         * thenApply()
         * thenCompose()
         *
         * 相同点：thenApply()和thenCompose()都用于连接多个CompletableFuture调用
         * 不同点：
         */

//        testThenApplyAsync();
//        testThenCompose();


        /**
         * 3.两个任务执行是and的关系：两个任务执行后对返回结果进行聚合返回
         * thenCombine():聚合结果有返回值
         * thenAcceptBoth():聚合接果没有返回值
         * runAfterBoth():兩个任务都执行完成后执行新的runnable 方法
         */

//        testThenCombine();
//        testThenAcceptBoth();
//        testRunAfter();

        /**
         * 4.两个任务执行是或的关系：两个任务谁执行快用谁的谁的结果
         * applyToEither():两个结果谁执行快用谁的结果，有返回值
         * acceptEither():两个结果谁执行快用谁的结果，无返回值
         * runAfterEither():两个结果有一个执行完了就执行新写的runnable
         */
//        testsApplyToEither();
//        testAcceptEither();
        testRunAfterEither();



    }




    private static void testSupplyAsync() {
        try {
            Integer a=CompletableFuture.supplyAsync(()->{
                System.out.println("supplyAsync1 "+Thread.currentThread().getName());
                return 1;
            }).get();
            System.out.println(a);

            ExecutorService executorService= Executors.newFixedThreadPool(10);
            Integer b=CompletableFuture.supplyAsync(()->{
                System.out.println("supplyAsync2 "+Thread.currentThread().getName());
                return 2;
            },executorService).get();
            System.out.println(b);


        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    private static void testRunAsync() {
        CompletableFuture.runAsync(()->{
            System.out.println("runAsync1"+Thread.currentThread().getName());
        });

        ExecutorService executorService= Executors.newFixedThreadPool(10);

        CompletableFuture.runAsync(()->{
            System.out.println("runAsync2"+Thread.currentThread().getName());
        },executorService);
    }


    private static void testThenApplyAsync() throws ExecutionException, InterruptedException {
        int finalI=CompletableFuture.supplyAsync(()->{
            int i=1;
            System.out.println("执行第一个任务 i= "+i+"   "+Thread.currentThread().getName());
            return ++i;
        }).thenApply(i->{
            System.out.println("执行第二个任务 i= "+i+"   "+Thread.currentThread().getName());
            return ++i;
        }).thenApply(i->{
            System.out.println("执行第三个任务 i= "+i+"   "+Thread.currentThread().getName());
            return ++i;
        }).thenApplyAsync(i->{
            System.out.println("执行第四个任务 i= "+i+"   "+Thread.currentThread().getName());
            return ++i;
        }).get();

        System.out.println(finalI);
    }



    private static void testThenCompose() throws ExecutionException, InterruptedException {
        int finalI=CompletableFuture.supplyAsync(()->{
            System.out.println("执行第一个任务 "+"   "+Thread.currentThread().getName());
            return 1;
        }).thenCompose(a->CompletableFuture.supplyAsync(()->{
            System.out.println("执行第二个任务 "+"   "+Thread.currentThread().getName());
            return a;
        })).get();
        System.out.println(finalI);
    }

    private static void testThenCombine() throws ExecutionException, InterruptedException {
        Integer result=CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第一个任务 "+"   "+Thread.currentThread().getName());
            return 1;
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第二个任务 "+"   "+Thread.currentThread().getName());
            return 2;
        }),(a,b)->{
            System.out.println("执行合并任务 "+"   "+Thread.currentThread().getName());
            return a+b;
        }).get();
        System.out.println(result);
    }


    private static void testThenAcceptBoth() {

    }

    private static void testsApplyToEither() throws ExecutionException, InterruptedException {
        Integer a=CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第一个任务 "+"   "+Thread.currentThread().getName());
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第二个任务 "+"   "+Thread.currentThread().getName());
            return 2;
        }),i-> i).get();
        System.out.println(a);
    }

    private static void testAcceptEither() throws ExecutionException, InterruptedException {

        CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第一个任务 "+"   "+Thread.currentThread().getName());
            return 1;
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第二个任务 "+"   "+Thread.currentThread().getName());
            return 2;
        }), System.out::println).get();
    }


    private static void testRunAfterEither() throws ExecutionException, InterruptedException {
       CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第一个任务 "+"   "+Thread.currentThread().getName());
            return 1;
        }).runAfterEither(CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("执行第二个任务 "+"   "+Thread.currentThread().getName());
            return 2;
        }),()->{
            System.out.println("我再这两个任务人一个比较快的执行完以后就到我执行了"+Thread.currentThread().getName());
        }).get();

    }





}
