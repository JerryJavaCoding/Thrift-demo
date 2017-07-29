package com.jerry.learning.original;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


import java.util.List;

/**
 * Created by Jerry on 2017/7/28.
 */
public class Client {
    public static void main(String[] args) throws TException {
        TTransport transport=new TSocket("localhost",6031,30000);
        TProtocol protocol=new TBinaryProtocol(transport);
        RegisteService.Client client = new RegisteService.Client(protocol);
        transport.open();
        Userinfo userinfo=new Userinfo();
        userinfo.setId(1);
        userinfo.setName("jerry");
        userinfo.setRegiste_price(10.22);
        int registe = client.registe(userinfo);
        List<Userinfo> userInfos = client.getUserInfo();
        for (Userinfo userInfo:userInfos) {
            System.out.println(userInfo.getRegiste_price());
        }


    }
}
