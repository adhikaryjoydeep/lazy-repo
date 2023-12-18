package com.lazypractice.controller;

import com.lazypractice.beans.RawMateStock;
import com.lazypractice.repository.RawMateStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RawMateController {
    @Autowired
    private RawMateStockRepository repository;

    public RawMateController(RawMateStockRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rawMateStocks/{item}")
    public RawMateStock findStockByItem(@PathVariable String item){
        return repository.findRawMateByItem(item);
    }

    @PostMapping("/rawMateStocks/add")
    public RawMateStock addNewStock(RawMateStock rawMateStock){
    return repository.save(rawMateStock);

    }
}
