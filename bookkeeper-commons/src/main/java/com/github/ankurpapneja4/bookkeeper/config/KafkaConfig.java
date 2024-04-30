package com.github.ankurpapneja4.bookkeeper.config;

import com.github.ankurpapneja4.bookkeeper.model.enums.KafkaTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("kafka")
public class KafkaConfig {

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(KafkaTopic.NewInvoice.name())
                .partitions(1)
                .replicas(1)
                .build();
    }
}
