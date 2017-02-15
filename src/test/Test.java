package test;

import org.nutz.lang.Times;
import org.nutz.redis.dao.impl.RedisDao;
import org.nutz.redis.dao.util.Util;

/**
 * Created by Jianghao on 2017/2/13.
 */
public class Test {

    public static final void main(String args[]){


        User user = new User();
//        user.setId(11111);
        user.setComId(1);
        user.setUserName("GDV");
        user.setAddTime(Times.now());
        user.setLoginTime(Times.now());
        user.setGroupId(2);

        System.out.println(Util.getId(null));
        System.out.println(Util.getId(null));
        System.out.println(System.currentTimeMillis() /1000);
        new RedisDao().insert(user);
    }
}
