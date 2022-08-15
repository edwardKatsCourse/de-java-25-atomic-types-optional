package com.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class MainAtomic {

    // common resource
//    static int counter = 0;

    // CAS - Compare And Swap
    static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 100_000; i++) {
//                counter++;

                counter.incrementAndGet();
                // counter v1 -> v2
                // t1 -> counter v1 -> counter = 0
                // t2 -> counter v1 -> counter = 0

                // t1 -> counter++ -> counter = 1 v2
                // t2 -> counter++ v1 -> v2 -> counter 1 -> counter++ -> v3


                // Race Condition

                // Thread Cache

                // t3
                // ---------- synchronization - one-thread-at-a-time ----------
//                int counterCopy = counter;
                // t2 - counter = 1
//                counterCopy = counterCopy + 1;
//                counter = counterCopy;

                // with volatile - happens before
                int abc = 0;
                abc = 0 + 1;
                // t1 - t2

                // t1 - counter = 1

                Object obj = null;
                // t2
                if (obj == null) {
                    obj = new Object(); // t1
                }

                // 1. allocate memory
                // 2. create object metadata
                //      obj != null (without Happens-Before)
                // 3. create an object + set to heap
                // 4. assign reference with obj

                // 5. obj != null (with Happens-Before)


                // Default Case
                // t1 - counter = 1 -> counterCopy = 1
                // t2 - counter = 1 -> counterCopy = 1
            }
            // race condition
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println(counter);
    }


}
