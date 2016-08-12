package com.crazyacking.template;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Mengyu.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-beans.xml"})
public class HelloWorkerTest {

    @Autowired
    HelloWorker helloWorker;

    @Resource(name = "localFinalCache")
    ConcurrentLinkedHashMap<String, Integer> localFinalCache;

    @Test
    public void sayHello() throws Exception {

    }

    @Test
    public void localFinalCacheTest() throws Exception {
        initFinalCache();

        ConcurrentLinkedHashMap<String, Integer> tempCache = localFinalCache;
        for (Map.Entry<String, Integer> entry : tempCache.entrySet()) {
            if (entry.getValue().equals(1)) {
                tempCache.remove(entry.getKey());
            }
        }

        System.out.println(tempCache.size());
        System.out.println(localFinalCache.size());

        printResult();
    }

    private void printResult() {
        for (Map.Entry<String, Integer> entry : localFinalCache.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private void initFinalCache() {
        localFinalCache.put("aaa", 1);
        localFinalCache.put("bbb", 2);
        localFinalCache.put("ccc", 3);

    }

}