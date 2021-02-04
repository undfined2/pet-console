package com.unify.petconsole.writer;

import com.unify.petconsole.PetConsoleApplication;
import com.unify.petconsole.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PetStoreConsoleLogger {

    private static Logger LOG = LoggerFactory
            .getLogger(PetConsoleApplication.class);

    public void printOrderedPetList(ResponseEntity<Pet[]> responseEntity) {
        List<Pet> pets = Arrays.stream(responseEntity.getBody())
                .collect(Collectors.toList());

//        Wasn't sure if I could do the sorting in the above stream. I tried, but was getting exceptions, and
//        when I separated it, it worked, so I ran with it

        pets.stream()
                .sorted(Comparator.comparing(Pet::getName).reversed())
                .sorted(Comparator.comparing(Pet::getCategoryName))
                .forEach(pet -> LOG.info(pet.toString()));
    }

}
