package org.nutz.redis.dao.entity.annotation;

import java.lang.annotation.*;

/**
 * Created by Jianghao on 2017/2/8
 * User.class.getAnnotation(KeyPrefix.class).value() = aitaohuo:user:
 * @howechiang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface KeyPrefix {
    String value();
}
