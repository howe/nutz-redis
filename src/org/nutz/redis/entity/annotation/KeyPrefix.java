package org.nutz.redis.entity.annotation;

import java.lang.annotation.*;

/**
 * Created by Jianghao on 2017/2/8
 *
 * @howechiang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface KeyPrefix {

    String value();
}
