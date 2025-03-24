package com.example.spring6restmvc.controller;

import com.example.spring6restmvc.model.BeerDTO;
import com.example.spring6restmvc.service.BeerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{id}")
    public BeerDTO getBeerById(@PathVariable(value = "id") UUID id) {
        log.info("Get Beer by id in controller");
        return beerService.getBeerById(id).orElseThrow(RuntimeException::new);
    }
    @GetMapping()
    public List<BeerDTO> listBeers() {
        return beerService.listBeers();
    }

    @PostMapping()
    public ResponseEntity<BeerDTO> createBeer(@Valid @RequestBody BeerDTO beer) {
        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }
}
