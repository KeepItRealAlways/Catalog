package org.neriko.catalog.controllers;

import org.neriko.catalog.entities.ProductOffering;
import org.neriko.catalog.entities.ProductSpecification;
import org.neriko.catalog.repositories.ProductSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductSpecificationController {

    @Autowired
    private ProductSpecificationRepository productSpecificationRepository;

    @GetMapping(value = "/productSpecification")
    @ResponseBody
    public List<ProductSpecification> listProductSpecifications(@RequestParam(required = false, value = "fields") List<String> fields) {
        return productSpecificationRepository.findAll();
    }

    @GetMapping("/productSpecification/{id}")
    @ResponseBody
    public ProductSpecification getProducSpecification(@PathVariable String id,
                                              @RequestParam(required = false, value = "fields") List<String> fields) {
        return productSpecificationRepository.getOne(id);
    }
}
