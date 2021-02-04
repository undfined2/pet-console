package com.unify.petconsole;

import com.unify.petconsole.service.PetStoreRestService;
import com.unify.petconsole.writer.PetStoreConsoleLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;




@SpringBootApplication
public class PetConsoleApplication {

    private static Logger LOG = LoggerFactory
            .getLogger(PetConsoleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PetConsoleApplication.class, args);
        }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
        }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        return args -> {

            PetStoreConsoleLogger petStoreConsoleLogger = new PetStoreConsoleLogger();
            PetStoreRestService petStoreRestService = new PetStoreRestService();
            petStoreConsoleLogger.printOrderedPetList(petStoreRestService.getPetStoreAvailabilityEntity(restTemplate));

        };
    }


}



