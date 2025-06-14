package com.crosinfo.str_consumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import com.crosinfo.str_consumer.custom.StrConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@KafkaListener(groupId = "group-0", topicPartitions = {
			@TopicPartition(topic = "str-topic", partitions = {"0"})
	}, containerFactory = "strContainererFactory")
	public void custom(String message) {
		log.info("CUSTOM ::: Receive message: {}", message);

	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message: {}", message);

	}

	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message: {}", message);

	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void history(String message) {
		log.info("HISTORY ::: Receive message: {}", message);

	}
	
	@StrConsumerCustomListener(groupId = "group-2")
	public void group2(String message) {
		log.info("GROUP ::: Receive message: {}", message);

	}
}
