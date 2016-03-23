package com.realdolmen.course.domain.threading;

import java.util.concurrent.*;

/**
 * Created by heleneshaikh on 22/03/16.
 */
public class Runner {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Executor:  interface that supports launching new tasks.
        ExecutorService executorService = Executors.newFixedThreadPool(4); //thread pool containing 4 threads to reuse
        MyTask task = new MyTask();
        //asynchroon. taak aanbieden, offloaden naar 1 vd 4 threads => queue
        Future<Integer> future = executorService.submit(task);

        long start = System.nanoTime();
        //do some stuff while waiting for answer


        System.out.println("1 Doing extra work");
        Thread.sleep(3000);
        System.out.println("Doing more extra work");
        Thread.sleep(3000);
        Integer i = future.get(); //beginnen wachten of antwoord terug geven

        System.out.println("Done " + i);

        long end = System.nanoTime();
        System.out.println((end - start) / 1000000000 + "seconds");
    }
}

class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("still calculating though work");
            Thread.sleep(1000);
        }
        return 5 * 8;
    }
}
