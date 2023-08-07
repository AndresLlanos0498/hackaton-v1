package api.service.hackatonv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(lazyInit = true)
@SpringBootConfiguration
@SpringBootApplication
public class HackatonV1Application /*extends StarterWebApplication*/{

    public static void main(String[] args) {
        SpringApplication.run(HackatonV1Application.class, args);
    }

}
