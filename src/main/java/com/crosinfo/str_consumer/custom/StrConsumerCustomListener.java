package com.crosinfo.str_consumer.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrConsumerCustomListener {
	
	@AliasFor(annotation = KafkaListener.class, attribute = "topics")
	String[] topics() default "str-topic";
	
	@AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
	String containerFactory() default "strContainererFactory";
	
	@AliasFor(annotation = KafkaListener.class, attribute = "groupId")
	String groupId() default "";

}
