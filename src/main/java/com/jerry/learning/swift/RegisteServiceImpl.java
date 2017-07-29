package com.jerry.learning.swift;

import com.facebook.swift.codec.ThriftField;
import org.apache.thrift.TException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Jerry on 2017/7/29.
 */
public class RegisteServiceImpl implements  RegisteService {
    List<Userinfo> userinfos=new CopyOnWriteArrayList<>();//多线程list
    @Override
    public int registe(@ThriftField(value = 1, name = "userinfo") Userinfo userinfo) throws TException {
         userinfos.add(userinfo);
        return 1;
    }

    @Override
    public List<Userinfo> getUserInfo() throws TException {
        return userinfos;
    }

    @Override
    public void close() throws Exception {

    }
}
