package org.nutz.redis.dao.entity.annotation;

import java.lang.annotation.*;

/**
 * major key 主关键字
 * Created by Jianghao on 2017/2/10.
* for (Field k : User.class.getDeclaredFields()){
 *   if(!Lang.isEmpty(k.getAnnotation(MK.class)))
 *      System.out.println(k + " 注解了：" + k.getAnnotation(MK.class));
 * }
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface MK {}
