package com.wm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: jqw
 * @version: 1.0.0
 * @description:
 * @date Date: 2023年01月17日 15:57:00
 */
public class CompletableTest {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        List<CompletableFuture<?>> futureAll = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int index = i;
            futureAll.add(CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("线程：CompletableFuture" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return index;
            }));
        }
        //等待全部执行完成
        CompletableFuture.allOf(futureAll.toArray(new CompletableFuture[0])).join();
        //获取内容
        for (CompletableFuture future : futureAll) {
            try {
                Object s = future.get();
                System.out.println(s);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread().getName());
        System.out.println("运行时间：" + (end - start));
    }
}