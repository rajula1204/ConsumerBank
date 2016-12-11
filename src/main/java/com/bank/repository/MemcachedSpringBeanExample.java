package com.bank.repository;

import javax.inject.Inject;
import javax.inject.Named;

import net.spy.memcached.MemcachedClient;

@Named
public class MemcachedSpringBeanExample {

    private MemcachedClient memcached;

    @Inject
    protected MemcachedSpringBeanExample(@Named("memcached.client") MemcachedClient memcached) {
        this.memcached = memcached;
    }

    public void doSomething() {
        memcached.add("my_bean_key", 2000, new Object[] { "val1", "val2" });
    }
}
