package document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class documentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(documentServiceApplication.class, args);
    }

}
