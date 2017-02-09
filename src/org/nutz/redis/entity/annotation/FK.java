package org.nutz.redis.entity.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明了一个 POJO 的主键。
 * <p>
 * 本注解声明在某一个 POJO 类上，例如：
 *
 * <pre>
 * &#064;KeyPrefix("t:abc")
 * &#064;FK({"id", "type"})
 * public class Abc{
 * ...
 * </pre>
 * 其中， "id" 和 "type" 必须是这个 POJO 的 Java 字段名
 *
 * </ul>
 *
 * @author howechiang@gmail.com
 *
 * User.class.getAnnotation(FK.class) = ["comId", "groupId"]
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface FK {
    String[] value();
}
