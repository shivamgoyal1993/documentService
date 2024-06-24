package document.bellas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "aodocs-service", url = "https://catfact.ninja" , path = "/fact")
public interface BellasOCRClient {
    @GetMapping()
    public String getDocumentById();

}
