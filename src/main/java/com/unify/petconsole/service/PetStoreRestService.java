package com.unify.petconsole.service;

import com.unify.petconsole.model.Pet;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PetStoreRestService {

    public ResponseEntity<Pet[]> getPetStoreAvailabilityEntity(RestTemplate restTemplate) {
        ResponseEntity<Pet[]> responseEntity = restTemplate.getForEntity
                ("https://petstore.swagger.io/v2/pet/findByStatus?status=available",
                        Pet[].class, new ParameterizedTypeReference<Pet>() {
                        });
        return responseEntity;
    }
}
