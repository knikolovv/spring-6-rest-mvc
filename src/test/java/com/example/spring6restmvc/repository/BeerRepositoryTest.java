package com.example.spring6restmvc.repository;

import com.example.spring6restmvc.entities.Beer;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeer() {


        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("Ariana 23457896342568097324605230467895607324567932460757602340675607324567324067507632460572346075")
                    .upc("4555")
                    .build());

            beerRepository.flush();
        });



//        assertThat(savedBeer).isNotNull();
//        assertThat(savedBeer.getId()).isNotNull();
    }
}