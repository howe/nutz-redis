package org.nutz.redis.dao;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.lang.reflect.Field;

/**
 * Created by Jianghao on 2017/2/13.
 */
public class ObjUtil {

    private static final Log log = Logs.get();

    public static Object getValue(Object obj, String fieldName){
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(obj);
            return value;
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
