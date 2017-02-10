package org.nutz.redis.dao.impl;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.aop.Aop;
import org.nutz.redis.dao.RDao;

import static org.nutz.integration.jedis.RedisInterceptor.jedis;

/**
 * Created by Jianghao on 2017/2/10.
 */
public class RedisDao implements RDao {


    @Override
    public Pager createPager(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    @Aop("redis")
    public <T> T fetch(Class<T> classOfT, String id) {

        return null;
    }

    @Override
    @Aop("redis")
    public <T> T fetch(String keyPrefix, Class<T> classOfT, String id) {
        return null;
    }

    @Override
    @Aop("redis")
    public <T> T fetchLinks(T obj, String regex) {
        return null;
    }

    @Override
    @Aop("redis")
    public int clear(String keyPrefix) {
        return 0;
    }

    @Override
    @Aop("redis")
    public int delete(String keyPrefix, Object obj) {
        return 0;
    }

    @Override
    @Aop("redis")
    public int delete(String keyPrefix, Class<?> classOfT, String id) {
        return 0;
    }

    @Override
    @Aop("redis")
    public int count(String keyPrefix) {
        return 0;
    }

    @Override
    @Aop("redis")
    public <T> T insert(T obj) {

        jedis().zadd()
        return null;
    }

    @Override
    @Aop("redis")
    public <T> T insert(String keyPrefix, T obj) {
        return null;
    }

    @Override
    @Aop("redis")
    public int update(Object obj) {
        return 0;
    }
}
