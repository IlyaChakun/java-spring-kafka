package ch.chakun.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
class KafkaTopicConfig {

    @Value("${kafka.simple.topic}")
    private String defaultTopic;

    @Value("${kafka.orders.topic}")
    private String ordersTopic;

    @Bean
    public NewTopic defaultTopic() {
        return TopicBuilder.name(defaultTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic ordersTopic() {
        return TopicBuilder.name(ordersTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

}