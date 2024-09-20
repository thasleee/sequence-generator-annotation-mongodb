package com.sequence_generator_annotation_mongodb.configurations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateSequence {
    String sequenceName() default "sequence";
    String prefix() default "USER";
    int padding() default 3;
}
