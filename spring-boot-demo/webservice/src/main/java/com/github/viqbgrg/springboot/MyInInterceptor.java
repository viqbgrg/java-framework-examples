package com.github.viqbgrg.springboot;

import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

import static org.apache.cxf.message.Message.REQUEST_URL;

public class MyInInterceptor extends AbstractInDatabindingInterceptor {

    private String url;

    public MyInInterceptor(String url) {
        super(Phase.USER_STREAM);
        this.url = url;
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        message.put(REQUEST_URL, url);
    }
}