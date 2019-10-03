package org.neriko.catalog.controllers;

import org.neriko.catalog.entities.ProductOfferingPrice;
import org.neriko.catalog.entities.ProductSpecification;
import org.neriko.catalog.repositories.ProductOfferingPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductOfferingPriceController {

    @Autowired
    private ProductOfferingPriceRepository productOfferingPriceRepository;

    @GetMapping(value = "/productOfferingPrice")
    @ResponseBody
    public List<ProductOfferingPrice> listProductOfferingPrice(@RequestParam(required = false, value = "fields") List<String> fields) {
        return productOfferingPriceRepository.findAll();
    }

    @GetMapping("/productOfferingPrice/{id}")
    @ResponseBody
    public ProductOfferingPrice getProductOfferingPrice(@PathVariable String id,
                                                       @RequestParam(required = false, value = "fields") List<String> fields) {
        return productOfferingPriceRepository.getOne(id);
    }

    @PostMapping("/productOfferingPrice")
    @ResponseBody
    public ProductOfferingPrice createProductOfferingPrice(@RequestBody ProductOfferingPrice productOfferingPrice) {
        return productOfferingPriceRepository.save(productOfferingPrice);
    }

    //TODO реализовать
    @PatchMapping(value = "/productOfferingPrice/{id}")
    @ResponseBody
    public void updateProductOfferingPrice(@RequestBody Map<String, Object> patch, @PathVariable String id) { }

    @DeleteMapping("/productSpecification/{id}")
    @ResponseBody
    public void deleteProductOfferingPrice(@PathVariable String id) {
        productOfferingPriceRepository.deleteById(id);
    }
}
