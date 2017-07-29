package com.jerry.learning.original;



import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2017/7/28.
 */
public class RegisteServiceImpl implements RegisteService.Iface{
    List<Userinfo> users=new ArrayList<>();
    @Override
    public int registe(Userinfo userinfo) throws TException {
        users.add(userinfo);
        System.out.println("注册新用户："+userinfo.getName());
        return 1;
    }

    @Override
    public List<Userinfo> getUserInfo() throws TException {
        return users;
    }
}
