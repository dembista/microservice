package com.ecole221.l3devweb.first.config;


import com.ecole221.l3devweb.common.service.event.AgeEvent;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Consumer {
    @Bean
    public ConsumerFactory<String, AgeEvent> AgeEventConsumer() {

        // HashMap to store the configurations
        Map<String, Object> map
                = new HashMap<>();

        // put the host IP in the map
        map.put(ConsumerConfig
                        .BOOTSTRAP_SERVERS_CONFIG,
                "localhost:19092");

        map.put(ConsumerConfig
                        .KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        map.put(ConsumerConfig
                        .VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        // return message in JSON formate
        return new DefaultKafkaConsumerFactory<>(
                map, new StringDeserializer(),
                new JsonDeserializer<>(AgeEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AgeEvent> AgeEventListner()
    {
        ConcurrentKafkaListenerContainerFactory<String, AgeEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(AgeEventConsumer());
        return factory;
    }
}
