package com.documentService;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {


    @KafkaListener(topics = AppConstants.AODOCS_DOCUMENT_TOPIC, groupId = AppConstants.AODOCS_GROUP_ID)
    public void getDocuments(String value) {

        System.out.println("Received aodocs documents: " + value);
    }

    @KafkaListener(topics = AppConstants.ACCORD_DOCUMENT_TOPIC, groupId = AppConstants.ACCORD_GROUP_ID)
    public void getContracts(String value) {

        System.out.println("Received accord contracts: " + value);
    }

}
