package com.lc.spring.db.aspect;

import java.lang.annotation.*;

/**
 * Created by LC on 2017/11/2.
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String name() default "";
}
