package com.unify.petconsole.writer;

import com.unify.petconsole.model.Category;
import com.unify.petconsole.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PetStoreConsoleLoggerTest {


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static final String expectedResult = " [main] INFO com.unify.petconsole.PetConsoleApplication - Pet Name = 'Aqua', id =2, Category = 'duck' [main] INFO com.unify.petconsole.PetConsoleApplication - Pet Name = 'Bubbles', id =3, Category = 'fish' [main] INFO com.unify.petconsole.PetConsoleApplication - Pet Name = 'Feathers', id =1, Category = 'peacock'";

    private static final Pet PET3 = new Pet(3L, (new Category(7L, "fish")),
            "Bubbles", null, null, "active");
    private static final Pet PET2 = new Pet(2L, (new Category(8L, "duck")),
            "Aqua", null, null, "active");
    private static final Pet PET1 = new Pet(1L, (new Category(9L, "peacock")),
            "Feathers", null, null, "active");

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    PetStoreConsoleLogger consoleLogger = new PetStoreConsoleLogger();

    @Test
    @DisplayName("Should order output by category")
    void shouldOrderOutputByCategory() {
        Pet[] pets = {PET1, PET2, PET3};
        ResponseEntity<Pet[]> entity = new ResponseEntity(pets, HttpStatus.OK);

        consoleLogger.printOrderedPetList(entity);

        assertEquals(expectedResult, outputStreamCaptor.toString()
                .lines().map(str -> str.substring(12)).collect(Collectors.joining()));

    }


}