package com.bank.handler;

import java.io.IOException;
import java.net.InetSocketAddress;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.spy.memcached.MemcachedClient;


public class ContextListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);
	public static MemcachedClient client =null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	logger.info("contextInitialized..started");
    	ContextListener.createClient();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    static void createClient() {
        try {
        	logger.info("createClient..started");
            client = new MemcachedClient(new InetSocketAddress("localhost", 11211));
            logger.info("createClient..after");
        } catch (IOException ex) {
          logger.error("error in ContextListener..:"+ex.getMessage(),ex);
        	// Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static MemcachedClient getClient() throws IOException {
        return client;
    }
}