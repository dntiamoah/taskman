package com.ntiamoah.springboot.taskman.task;

import org.springframework.stereotype.Service;

/**
 * Created by dntiamoah on 17/05/2018.
 */
@Service
public class TaskService {

    public void doit(String reverse) {
        Double a1 = new Double(10);
        Double a2 = new Double(10);

        if ( a1 == a2 ) {
            System.out.print("yep a1 == a2 same");
        }
        if (a1.equals(a2)) {
            System.out.print("yep a1.equals(a2) same");
        }

    }
}
