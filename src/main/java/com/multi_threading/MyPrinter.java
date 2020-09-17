package com.multi_threading;

import lombok.*;

/**
 * @author Evgeny Borisov
 */
@Data
@RequiredArgsConstructor
public class MyPrinter implements Runnable {
    private final int x;
    private boolean moreWorkToDo = true;

    @Override
    public void run() {
        while (moreWorkToDo) {
            System.out.println(x);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                moreWorkToDo=false;
            }
        }
    }
}
