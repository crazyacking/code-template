package com.crazyacking.template;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mengyu on 2016/8/12.
 */
@Configuration
public class HelloConfig {

    @Bean(name = "localFinalCache")
    public ConcurrentLinkedHashMap<String, Integer> createLocalFinalCache() {
        return new ConcurrentLinkedHashMap.Builder<String, Integer>()
                .maximumWeightedCapacity(55555)
                .build();
    }
}
