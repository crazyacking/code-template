package com.crazyacking.template;

import org.springframework.stereotype.Component;

/**
 * Created by Mengyu.
 */
@Component("helloWorker")
class HelloWorker {
    public void sayHello(String user) {
        System.out.println("HelloWorker, " + user);
    }
}
