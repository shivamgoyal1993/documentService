package document.repository;

import document.entity.DocumentMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends JpaRepository<DocumentMetadata, Integer> {

    public DocumentMetadata getDocumentById(int id);

}
