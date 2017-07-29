package com.jerry.learning.original;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Jerry on 2017/7/28.
 */
public class Server {
    public static void main(String[] args1) throws TTransportException {
        TServerTransport tServerTransport=new TServerSocket(6031);

        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
        TProcessor processor=new RegisteService.Processor(new RegisteServiceImpl());
        TThreadPoolServer.Args args=new TThreadPoolServer.Args(tServerTransport).protocolFactory(factory).processor(processor);
        TServer server= new TThreadPoolServer(args);
        System.out.println("服务已启动。。。。");
        server.serve();
    }
}
