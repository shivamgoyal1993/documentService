package document.controller;

//import document.entity.DocumentMetadata;
import document.documentService.KafkaConsumerConfig;
import document.entity.DocumentMetadata;
import document.repository.DocumentRepo;
import document.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
@RequestMapping("/document")
public class DocumentController {

    Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentRepo documentRepo;

    @Autowired
    private DocumentService documentService;

    @GetMapping("/id/{id}")
    private ResponseEntity<DocumentMetadata> getDocument(@PathVariable int id){
        DocumentMetadata documentMetadata = documentService.getDocument(id);
        logger.info("Document with id {} has been retrieved", documentMetadata.getId());
        return new ResponseEntity<>(documentMetadata,HttpStatus.OK);
    }

    @PostMapping("/add")
    private ResponseEntity<DocumentMetadata> add(@RequestBody DocumentMetadata documentMetadata){
        DocumentMetadata  result = documentRepo.save(documentMetadata);
        logger.info("Document with id {} has been saved to db", result.getId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
