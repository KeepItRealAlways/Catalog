package org.neriko.catalog.controllers;

import org.neriko.catalog.entities.ProductOffering;
import org.neriko.catalog.repositories.ProductOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductOfferingController {

    @Autowired
    private ProductOfferingRepository productOfferingRepository;

    @GetMapping(value = "/productOffering")
    @ResponseBody
    public List<ProductOffering> listProductOfferings(@RequestParam(required = false, value = "fields") List<String > fields) {
        return productOfferingRepository.findAll();
    }

    @GetMapping("/productOffering/{id}")
    @ResponseBody
    public ProductOffering getProductOffering(@PathVariable String id,
                              @RequestParam(required = false, value = "fields") List<String > fields) {
        return productOfferingRepository.getOne(id);
    }

    @PostMapping("/productOffering")
    @ResponseBody
    public ProductOffering createProductOffering(@RequestBody ProductOffering productOffering) {
        return productOfferingRepository.save(productOffering);
    }

    //TODO реализовать
    @PatchMapping(value = "/productOffering/{id}")
    @ResponseBody
    public void updateProductOffering(@RequestBody Map<String, Object> patch, @PathVariable String id) { }

    @DeleteMapping("/productOffering/{id}")
    @ResponseBody
    public void deleteProductOffering(@PathVariable String id) {
        productOfferingRepository.deleteById(id);
    }
}
