package com.crazyacking.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mengyu.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hello-beans.xml"})
public class HelloWorkerTest {

    @Autowired
    HelloWorker helloWorker;

    @Test
    public void sayHello() throws Exception {
        helloWorker.sayHello("crazyacking");
    }

}