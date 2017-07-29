package com.jerry.learning.swift;

import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServerConfig;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.google.common.collect.ImmutableList;


/**
 * Created by Jerry on 2017/7/29.
 */
public class Server {
    public static void main(String[] args) {
        RegisteService registeService=new RegisteServiceImpl();
        ThriftServiceProcessor  processor = new ThriftServiceProcessor(new ThriftCodecManager(),  ImmutableList.<ThriftEventHandler>of(),registeService);
        ThriftServer server = new ThriftServer(processor, new ThriftServerConfig().setPort(8899));
        server.start();
    }
}
