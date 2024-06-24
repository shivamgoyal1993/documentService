package document.service;

import document.bellas.BellasOCRClient;
import document.controller.DocumentController;
import document.entity.DocumentMetadata;
import document.repository.DocumentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    Logger logger = LoggerFactory.getLogger(DocumentService.class);

    @Autowired
    private DocumentRepo documentRepo;

    @Autowired
    private BellasOCRClient bellasOCRClient;

    public DocumentMetadata getDocumentMetadataById(int id){
        String documentMetadata = bellasOCRClient.getDocumentById();
        System.out.println("documentMetadata from service getDocumentMetadataById >>>>>>>>>>>>>>>>> "
                +documentMetadata);
        DocumentMetadata d1 = new DocumentMetadata();
        d1.setId(12345);
        d1.setData(documentMetadata);
        d1.setSource("aodocs");
        return d1;
    }

    public DocumentMetadata getDocument(int documentId){
        return documentRepo.getDocumentById(documentId);
    }

    public void saveDocument(String value) {
        DocumentMetadata documentMetadata = new DocumentMetadata();
        documentMetadata.setData(value);
        documentMetadata.setSource(value.contains("AODocs") ? "AODocs" : "Accord");
        documentMetadata.setId(Integer.parseInt(value.replaceAll("[^0-9]", "")));
        documentRepo.save(documentMetadata);
        logger.info("document id {} , data {} , source {}",
                documentMetadata.getId(), documentMetadata.getData(), documentMetadata.getSource());
        logger.info("Document with id {} has been sent to database:", documentMetadata.getId());
    }


}
