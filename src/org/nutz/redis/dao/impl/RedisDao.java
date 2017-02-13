package org.nutz.redis.dao.impl;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.aop.Aop;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.redis.dao.ObjUtil;
import org.nutz.redis.dao.RDao;
import org.nutz.redis.dao.entity.annotation.FK;
import org.nutz.redis.dao.entity.annotation.KeyPrefix;
import org.nutz.redis.dao.entity.annotation.MK;
import org.nutz.redis.dao.entity.annotation.Orderby;

import java.lang.reflect.Field;
import java.util.Set;

import static org.nutz.integration.jedis.RedisInterceptor.jedis;

/**
 * Created by Jianghao on 2017/2/10.
 */
public class RedisDao implements RDao {

    @Override
    public Pager createPager(int pageNumber, int pageSize) {
        return null;
    }

    @Aop("redis")
    @Override
    public <T> T fetch(Class<T> classOfT, String id) {

        String val = jedis().get(classOfT.getAnnotation(KeyPrefix.class).value() + id);
        if(!Lang.equals(val, "nil") && !Lang.isEmpty(val))
            return Json.fromJson(classOfT, val);
        else
            return null;
    }

    @Aop("redis")
    @Override
    public <T> T fetch(String keyPrefix, Class<T> classOfT, String id) {
        String val = jedis().get(keyPrefix + id);
        if(!Lang.equals(val, "nil") && !Lang.isEmpty(val))
            return Json.fromJson(classOfT, val);
        else
            return null;
    }

    @Override
    public <T> T fetchLinks(T obj, String regex) {
        return null;
    }

    @Override
    public int clear(String keyPrefix) {
        return 0;
    }

    @Override
    public int delete(String keyPrefix, Object obj) {
        return 0;
    }

    @Override
    public int delete(String keyPrefix, Class<?> classOfT, String id) {
        return 0;
    }

    @Override
    public int count(String keyPrefix) {
        return 0;
    }

    @Aop("redis")
    @Override
    public <T> T insert(T obj) {

        System.out.println(obj.getClass().getTypeName());
        for (Field f : obj.getClass().getDeclaredFields()) {

            System.out.println(f.getType()+ " ----------- "+ f.getName()+ " ----------- " + ObjUtil.getValue(obj, f.getName()));
            if(!Lang.isEmpty(f.getAnnotation(MK.class)))
                System.out.println(f.getName() + " 注解了：" + f.getAnnotation(MK.class));
            if(!Lang.isEmpty(f.getAnnotation(Orderby.class)))
                System.out.println(f.getName() + " 注解了：" + f.getAnnotation(Orderby.class));
        }

        StringBuffer fk = new StringBuffer();
        for (String f : obj.getClass().getAnnotation(FK.class).value()){
            fk.append(f).append(":");
        }
        System.out.println(fk);
        System.out.println(obj.getClass().getAnnotation(KeyPrefix.class).value());
        System.out.println(Json.toJson(obj));

        return null;
    }

    @Override
    public <T> T insert(String keyPrefix, T obj) {
        return null;
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

}
