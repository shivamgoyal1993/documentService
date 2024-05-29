package com.documentService;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {


    @KafkaListener(topics = AppConstants.AODOCS_DOCUMENT_TOPIC, groupId = AppConstants.GROUP_ID)
    public void getDocuments(String value) {

        System.out.println("Received aodocs document: " + value);
    }

}
