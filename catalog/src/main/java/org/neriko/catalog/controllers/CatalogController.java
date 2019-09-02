package org.neriko.catalog.controllers;

import org.neriko.catalog.repositories.CatalogRepository;
import org.neriko.catalog.resource_models.catalog.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    CatalogRepository repository;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Catalog> list(@RequestParam List<String> fields) {
        return repository.findAll();
    }
}
