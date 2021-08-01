package org.denamyte.hyperskill.tasks.other;

import java.util.concurrent.Callable;

public class CallableAndFuture_HowManyCallableObjectsAreThere {

//    @SuppressWarnings("rawtypes")
//    public static int determineCallableDepth_test1(Callable callable) throws Exception {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        int count = 0;
//        Object maybeCallable = callable;
//        while (maybeCallable instanceof Callable) {
//            count++;
//            Future future = executor.submit(callable);
//            maybeCallable = future.get();
//        }
//        executor.shutdown();
//        return count;
//    }

    @SuppressWarnings("rawtypes")
    public static int determineCallableDepth(Callable callable) throws Exception {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        int count = 0;

        Object maybeCallable = callable;
        while (maybeCallable instanceof Callable) {
            count++;
            maybeCallable = ((Callable) maybeCallable).call();
        }
        return count;
    }

//    public static void main(String[] args) throws Exception {
//        Callable callable = () -> 4;
//        for (int i = 0; i < 4; i++) {
//            Callable finalCallable = callable;
//            callable = () -> finalCallable;
//        }
//
//        int result = determineCallableDepth(callable);
//        System.out.println(result);
//    }
}
