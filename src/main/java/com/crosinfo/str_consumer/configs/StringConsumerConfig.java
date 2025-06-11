package com.crosinfo.str_consumer.configs;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class StringConsumerConfig {
	
	public final KafkaProperties properties;
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		var configs = new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configs);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> strContainererFactory(
			ConsumerFactory<String, String> consumerFactory
	) {
		var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}
	
	/**
	 * 
	 * @param consumerFactory
	 * @return nao funciona corretamente na versao 3 do spring
	 */
	@Bean
	@Deprecated(forRemoval = true)
	public ConcurrentKafkaListenerContainerFactory<String, String> validMessageContainererFactory(
			ConsumerFactory<String, String> consumerFactory
	) {
		var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory);
//		factory.setRecordInterceptor(validMessage());
		return factory;
	}


//	private RecordInterceptor<String, String> validMessage() {
//		// TODO Auto-generated method stub
//		return record -> {
//			if(record.value().contains("Teste")) {
//				log.info("Possui a palavra Teste");
//				return record; 
//			}
//			log.warn("NAO possui a palavra Teste");
//			return record;
//		};
//	}
	
}
