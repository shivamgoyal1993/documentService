package document.documentService;


import document.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Configuration
public class KafkaConsumerConfig {
    Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Autowired
    private DocumentService documentService;

    @KafkaListener(topics = AppConstants.AODOCS_DOCUMENT_TOPIC, groupId = AppConstants.AODOCS_GROUP_ID)
    public void getDocuments(String value) {
        documentService.saveDocument(value);
        logger.info("template is received and sent to the service");
    }

    @KafkaListener(topics = AppConstants.ACCORD_DOCUMENT_TOPIC, groupId = AppConstants.ACCORD_GROUP_ID)
    public void getContracts(String value) {
        documentService.saveDocument(value);
        logger.info("contract is received and sent to the service");
    }

}
