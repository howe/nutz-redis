package org.nutz.redis.entity.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明一个字段排序
 * <p>
 * Orderby 字段，即排序标识。如果你将这个注解声明Date类型的字段上，会默认以Id排序
 * <p>
 * for (Field k : User.class.getDeclaredFields()){
 *   if(!Lang.isEmpty(k.getAnnotation(Id.class)))
 *      System.out.println(k + " 注解了：" + k.getAnnotation(Id.class));
 *   if(!Lang.isEmpty(k.getAnnotation(Orderby.class)))
 *      System.out.println(k + " 注解了：" + k.getAnnotation(Orderby.class));
 * }
 * private int com.aitaohuo.bean.User.id 注解了：@org.nutz.dao.entity.annotation.Id(auto=true)
 * private java.util.Date com.aitaohuo.bean.User.addTime 注解了：@org.nutz.redis.entity.annotation.Orderby()
 * @howechiang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface Orderby {}
