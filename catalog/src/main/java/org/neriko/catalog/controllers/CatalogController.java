package org.neriko.catalog.controllers;

import org.neriko.catalog.repositories.CatalogRepository;
import org.neriko.catalog.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping(value = "/catalog")
    @ResponseBody
    public List<Catalog> listCatalogs(@RequestParam(required = false, value = "fields") List<String > fields) {
        return catalogRepository.findAll();
    }

    @GetMapping("/catalog/{id}")
    @ResponseBody
    public Catalog getCatalog(@PathVariable String id,
                              @RequestParam(required = false, value = "fields") List<String > fields) {
        return catalogRepository.getOne(id);
    }

    @PostMapping("/catalog")
    @ResponseBody
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    //TODO реализовать
    @PatchMapping(value = "/catalog/{id}")
    @ResponseBody
    public void updateCatalog(@RequestBody Map<String, Object> patch, @PathVariable String id) { }

    @DeleteMapping("/catalog/{id}")
    @ResponseBody
    public void deleteCatalog(@PathVariable String id) {
        catalogRepository.deleteById(id);
    }
}
