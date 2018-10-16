package com.testing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {
    public static void main(String args[]) {

        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> future1 = squareCalculator.calculate(3);
        Future<Integer> future2 = squareCalculator.calculate(7);

        //This statement will cancel the future call
        //boolean canceled = future.cancel(true);

        try {
            while (!(future1.isDone() && future2.isDone())) {
                System.out.println(
                        String.format(
                                "future1 is %s and future2 is %s",
                                future1.isDone() ? "done" : "not done",
                                future2.isDone() ? "done" : "not done"
                        )
                );
                Thread.sleep(300);
            }
            Integer result = future1.get();
            Integer result2 = future2.get();
            System.out.println("results:" + result + "," + result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class SquareCalculator {

    //Uncomment and see how the multi threading works. Both works in parallel then.
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    //private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            //Delay added to mock the wait time
            Thread.sleep(1500);
            return input * input;
        });
    }
}
