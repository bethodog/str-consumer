package com.crosinfo.str_consumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainererFactory")
	public void create(String message) {
		log.info("CREATE ::: Receive message: {}", message);

	}

	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainererFactory")
	public void log(String message) {
		log.info("LOG ::: Receive message: {}", message);

	}
	
	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainererFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message: {}", message);

	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainererFactory")
	public void group2(String message) {
		log.info("GROUP ::: Receive message: {}", message);

	}
}
