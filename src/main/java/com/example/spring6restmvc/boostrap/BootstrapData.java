package com.example.spring6restmvc.boostrap;

import com.example.spring6restmvc.entities.Beer;
import com.example.spring6restmvc.model.BeerStyle;
import com.example.spring6restmvc.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) {
        loadBeerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer beerOne = Beer.builder()
                    .beerName("Stella")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12345")
                    .price(new BigDecimal("6.99"))
                    .quantityOnHand(120)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beerTwo = Beer.builder()
                    .beerName("Pirinsko")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("11111")
                    .price(new BigDecimal("4.99"))
                    .quantityOnHand(100)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beerThree = Beer.builder()
                    .beerName("Corona")
                    .beerStyle(BeerStyle.IPA)
                    .upc("55555")
                    .price(new BigDecimal("7.99"))
                    .quantityOnHand(150)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.saveAll(Arrays.asList(beerOne,beerTwo,beerThree));
        }
    }
}
