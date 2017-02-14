package org.nutz.redis.dao.util;

import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;

/**
 * Created by Jianghao on 2017/2/14.
 */
public class Util {

    private static final Log log = Logs.get();

    /**
     * 生成随机数字
     *
     * @param length 长度
     * @return
     */
    public static String getRandomNumber(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            buffer.append(base.charAt(number));
        }
        return buffer.toString();
    }

    /**
     * 生成随机字符
     *
     * @param length 长度
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            buffer.append(base.charAt(number));
        }
        return buffer.toString();
    }

    public static Object getValue(Object obj, String fieldName) {
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

    public static Object setValue(Object obj, String fieldName, Object fieldValue) {

        Map<String, Object> map = Lang.obj2map(obj);
        map.put(fieldName, fieldValue);
        return Lang.map2Object(map, obj.getClass());
    }

    public static Long getId(Long id) {

        if (Lang.isEmpty(id))
            return Long.parseLong(System.currentTimeMillis() + Util.getRandomNumber(5));
        else
            return id;
    }

    public static Long o2l(Object obj) {
        try {
            if (Lang.isEmpty(obj)) return 0L;
            return Long.valueOf(obj + "");
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }

    public static Integer o2i(Object obj) {
        try {
            if (Lang.isEmpty(obj)) return 0;
            return Integer.valueOf(obj + "");
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }

    public static Double o2d(Object obj) {
        try {
            if (Lang.isEmpty(obj)) return 0D;
            return Double.valueOf(obj + "");
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
            return 0D;
        }
    }
}
