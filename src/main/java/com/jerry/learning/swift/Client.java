package com.jerry.learning.swift;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import org.apache.thrift.TException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import static com.google.common.net.HostAndPort.fromParts;

/**
 * Created by Jerry on 2017/7/29.
 */
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TException {
        ThriftClientManager clientManager = new ThriftClientManager();
        FramedClientConnector connector = new FramedClientConnector(fromParts("localhost", 8899));
        Userinfo userinfo = new Userinfo();
        userinfo.setId(1);
        userinfo.setName("jerry");
        userinfo.setRegistePrice(10.22);
        try (RegisteService registeService = clientManager.createClient(connector, RegisteService.class).get()) {
            int registe = registeService.registe(userinfo);
            List<Userinfo> userInfos = registeService.getUserInfo();
            for (Userinfo userInfo : userInfos) {
                System.out.println(userInfo.getRegistePrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
